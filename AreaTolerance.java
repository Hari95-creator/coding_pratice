import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AreaTolerance {

    public static void areaCalculation(List<BigDecimal> areas, BigDecimal originalArea) {

        int roundingPrecision = 4;
        BigDecimal tolerance = new BigDecimal("0.0001");


        BigDecimal originalAreaRounded = originalArea.setScale(roundingPrecision, RoundingMode.HALF_UP);

   
        BigDecimal sumRounded = BigDecimal.ZERO;
        for (BigDecimal a : areas) {
            sumRounded = sumRounded.add(a.setScale(roundingPrecision, RoundingMode.HALF_UP));
        }

   
        BigDecimal difference = originalAreaRounded.subtract(sumRounded).abs();

        if (difference.compareTo(tolerance) > 0) {
            System.out.println(difference+ "LRM001: Parcel area differs from expected");
        } else {
            System.out.println("Area within tolerance");
        }
    }

    public static void main(String[] args) {

        List<BigDecimal> areaList = List.of(
                new BigDecimal("1156.4291101"),
                new BigDecimal("1143.771619"),
                new BigDecimal("1152.467957"),
                new BigDecimal("103.1333055")
        );

        BigDecimal originalArea = new BigDecimal("3555.895568");

        areaCalculation(areaList, originalArea);
    }
}

