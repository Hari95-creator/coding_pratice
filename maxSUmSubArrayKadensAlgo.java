public class maxSUmSubArrayKadensAlgo {

    public static int maxSubArray(int num[]){


        int currentSUm=0;
        int maxSum=num[0];


        for(int i=0;i<num.length;i++){

            currentSUm +=num[i];

            if(currentSUm > maxSum){

                maxSum=currentSUm;
            }

            if(currentSUm < 0){

                currentSUm=0;
            }

        }


        return maxSum;

    }


    public static void main(String args[]){


        int arr[]={1,-2,3,8,-6,11};

        int maxSum=maxSubArray(arr);

        System.out.println("Max Sum "+maxSum);
    }
    
}
