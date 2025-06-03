

JSONArray lands = new JSONArray();
String saleType = "";

try {

    // 1. To Get latest active process for LTIN

    // 1.1 Get premutation sketch request from ltinguid
    PremutationSketchRequest premutationSketchRequest = premutationSketchRequestRepository
            .findPreMutationSketchRequestBasedOnUserLtinGid(ltinGuid);
    if (premutationSketchRequest == null) {
        throw new CustomException("Pre Mutation SketchRequest Not Found !");
    }

    // 1.2 Get all parcels selected for sale
    JSONObject fullData = new JSONObject(responseEntity.getBody());
    JSONObject ST0015 = fullData.getJSONObject(stateCodeToReadData).getJSONObject("for_premutation");
    JSONArray propertyData = ST0015.getJSONArray("property");
    for (int i = 0; i < propertyData.length(); i++) {
        JSONObject land = new JSONObject();

        JSONObject j = propertyData.getJSONObject(i);
        saleType = j.optString("sale_type", ""); // To Do: Handle accordingly when multiple parcels for same
        // LTIN selected

        String parcelGid = j.getString("ulid");
        String locationCode = j.getString("dcode") + j.getString("tcode") + j.getString("vcode");
        PremutationSketchRequestParcels premutationSketchRequestParcels = premutationSketchRequestParcelsRepository
                .preMutationSketchRequestParcelSBasedOnSketchRequestId(premutationSketchRequest.getId(),
                        parcelGid);
        if (premutationSketchRequestParcels == null) {
            throw new CustomException("Pre Mutation SketchRequestParcels Not Found !");
        }
        PremutationSketchRequestProcess premutationSketchRequestProcess = premutationSketchRequestProcessRepository
                .findPreMutationSketchRequestProcessInitiatedBasedOnParcelAndRequestId(
                        premutationSketchRequest.getId(), premutationSketchRequestParcels.getId());
        if (premutationSketchRequestProcess == null) {
            throw new CustomException("Pre Mutation SketchRequestProcess Not Found !");
        }
        if (premutationSketchRequestProcess.getPremutationProcessStatusId().getId() == 90) {
            throw new CustomException("Pre Mutation SketchRequestProcess Already Initiated !");
        }

        // For Whole Sale type, directly create data structure and send to ILT
        if (saleType.equals("W")) {

            JSONObject landInfoBasedOnLandParcel = new JSONObject();
            landInfoBasedOnLandParcel.put("parcel_gid", parcelGid);

            JSONObject parcelInfoBasedOnLandParcel = emapsService.getParcelInfo(locationCode,
                    LocalLayerMaster.LAND_PARCEL.toString(),
                    URLEncoder.encode(landInfoBasedOnLandParcel.toString(), StandardCharsets.UTF_8), false);

            JSONObject ld = new JSONArray(parcelInfoBasedOnLandParcel.optString("data")).getJSONObject(0); // always
                                                                                                           // data
                                                                                                           // should
                                                                                                           // be
                                                                                                           // there

            JSONArray landArray = new JSONArray();
            JSONObject actualLand = new JSONObject();
            actualLand.put("ulpin", ld.getString("ulpin"));
            actualLand.put("mutation_flag", "BUYER_PARCEL");
            actualLand.put("ulid", parcelGid);
            actualLand.put("area_sqm", Util.roundToPrecision(
                    ld.getBigDecimal("area").setScale(4, RoundingMode.HALF_UP), AREA_ROUNDING_PRECISION));
            landArray.put(actualLand);
            if (!landArray.isEmpty()) {
                land.put(parcelGid, landArray);
                lands.put(land);
            }

            // updating current status in premutation
            PremutationProcessStatus premutationProcessStatus = premutationProcessStatusRepository
                    .getProcessStatusBySequenceNumber(Constants.PREMUTATION_PROCESS_STATUS_DATA_SENT);
            premutationSketchRequestParcels.setPremutationProcessStatusId(premutationProcessStatus);
            premutationSketchRequestParcelsRepository.save(premutationSketchRequestParcels);

            premutationSketchRequest.setPremutationProcessStatusId(premutationProcessStatus);
            premutationSketchRequestRepository.save(premutationSketchRequest);

            // saving history
            savePreMutationSketchRequestParcelsHistory(premutationSketchRequestParcels.getGid(),
                    "Data Sent to ILT",
                    premutationSketchRequestParcels.getPremutationSketchRequestId().getId());
            logger.info(
                    "Method : proceedForFinalizingMapData |  Parcel History Added Successfully");
        } else {
            // 2. Validate land sale process, if success directly do state update otherwise
            // mark for refix

            JSONObject attributes = new JSONObject();
            attributes.put("request_id", premutationSketchRequestProcess.getGid().toString());
            attributes.put("validate", true);
            try {
                JSONArray data = emapsService.validateAndReturnPremutationData(locationCode, attributes);
                if (data.length() > 0) {
                    List<Map<String, Object>> premutationLayers = new ArrayList<>();
                    List<Map<String, Object>> premutationNeighbourLayers = new ArrayList<>();
                    List<String> filterIdsMutation = new ArrayList<>();
                    List<String> filterIdsMutationNeighbours = new ArrayList<>();
                    JSONArray landArray = new JSONArray();
                    for (int k = 0; k < data.length(); k++) {
                        JSONObject ld = data.getJSONObject(k);
                        if (ld.getString("layer_code").equals(LocalLayerMaster.MUTATION.toString())) {
                            JSONObject attrs = ld.getJSONObject("attrs");
                            premutationLayers.add(
                                    Map.of("geom", ld.getString("geom"), "attrs", convertToMap(attrs)));
                            if (attrs.has("geom_record_id")) {
                                filterIdsMutation.add(attrs.getString("geom_record_id"));
                            }
                            JSONObject actualLand = new JSONObject();
                            actualLand.put("ulpin", ld.getString("ulpin"));
                            actualLand.put("mutation_flag", attrs.getString("mutation_flag"));
                            actualLand.put("ulid", attrs.getString("parcel_gid"));
                            actualLand.put("area_sqm", Double.parseDouble(ld.getString("area")) );
                            landArray.put(actualLand);
                        } else {
                            premutationNeighbourLayers.add(Map.of("geom", ld.getString("geom"), "attrs",
                                    convertToMap(ld.getJSONObject("attrs"))));
                            filterIdsMutationNeighbours
                                    .add(ld.getJSONObject("attrs").getString("geom_record_id"));
                        }
                    }
                    if (!landArray.isEmpty()) {
                        land.put(parcelGid, landArray);
                        lands.put(land);
                    }

                    if (premutationLayers.size() > 0 && filterIdsMutation.size() == 0) {
                        throw new CustomException("Validation failed for mutation.");
                    }
                    if (premutationNeighbourLayers.size() > 0 && filterIdsMutationNeighbours.size() == 0) {
                        throw new CustomException("Validation failed for mutation neighbours.");
                    }

                    saveMutationLayers(locationCode, premutationLayers, premutationNeighbourLayers,
                            filterIdsMutation, filterIdsMutationNeighbours);

                    // updating current status in premutation
                    PremutationProcessStatus premutationProcessStatus = premutationProcessStatusRepository
                            .getProcessStatusBySequenceNumber(
                                    Constants.PREMUTATION_PROCESS_STATUS_DATA_SENT);
                    premutationSketchRequestParcels.setPremutationProcessStatusId(premutationProcessStatus);
                    premutationSketchRequestParcelsRepository.save(premutationSketchRequestParcels);

                    premutationSketchRequest.setPremutationProcessStatusId(premutationProcessStatus);
                    premutationSketchRequestRepository.save(premutationSketchRequest);
                    // saving history
                    savePreMutationSketchRequestParcelsHistory(premutationSketchRequestParcels.getGid(),
                            "Data Sent to ILT",
                            premutationSketchRequestParcels.getPremutationSketchRequestId().getId());
                    logger.info(
                            "Method : proceedForFinalizingMapData |  Premutation Parcel History Added Successfully");
                }
            } catch (CustomException e) {
                logger.error(
                        "Method: PostSurveyService | Service : preMutationSketchRequestProcess | Error : ",
                        e);
                if (e.getMessage().equals("Validation failed for mutation")) {
                    // updating current status in premutation
                    PremutationProcessStatus premutationProcessStatus = premutationProcessStatusRepository
                            .getProcessStatusBySequenceNumber(
                                    Constants.PREMUTATION_PROCESS_STATUS_MAP_REFIX);

                    premutationSketchRequestParcels.setMapRefixRequestReceived(true);
                    premutationSketchRequestParcels.setMapRefixRequestReceivedDate(new Date());
                    premutationSketchRequestParcels.setPremutationProcessStatusId(premutationProcessStatus);
                    premutationSketchRequestParcelsRepository.save(premutationSketchRequestParcels);

                    premutationSketchRequest.setPremutationProcessStatusId(premutationProcessStatus);
                    premutationSketchRequestRepository.save(premutationSketchRequest);

                    // saving history
                    savePreMutationSketchRequestParcelsHistory(premutationSketchRequestParcels.getGid(),
                            "Map validation failed. Forwarded.",
                            premutationSketchRequestParcels.getPremutationSketchRequestId().getId());
                    logger.info(
                            "Method : requestAllocationUserAdd |  Premutation Parcel History Added Successfully");
                } else {
                    throw e;
                }
            }
        }
    }
} catch (Exception e) {
    logger.error("Method: PostSurveyService | Service : preMutationSketchRequestProcess | Error : ", e);
    throw e;
}

if (!lands.isEmpty()) {
    logger.info("Received lands from Bhunaksha service. Proceeding with finalizing geometry.");
    // proxy client update
    JSONObject metaData = new JSONObject();
    metaData.put("land", lands);

    String actionToTake = Actions.FINALIZE_GEOMETRY.getName();
    if(stateCodeToReadData.equals("ST0070")) {
        actionToTake = Actions.ACTION_FOR_MM_PUBLISH_SKETCH.getName();
    }
    proxyClientService.updateOverLtin(metaData, ltinGuid, actionToTake);
}

}