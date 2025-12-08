public class SubArray {


    public static void subArraySum(int[] arr,int k){

        int windowSum=0;
        int maxSum=0;

        for(int i=0;i< k;i++){

            windowSum +=arr[i];

        }

        for(int j=k;j< arr.length;j++){

            windowSum += arr[j]-arr[j-k];

            maxSum = Math.max(maxSum, windowSum);
        }

        
        System.out.println("Maximum Sum of Subarray of size " + k + " is: " + maxSum);
    }






    public static void main(String[] args){


        int arr[]={2,1,5,1,3,2};
        int k=3;

        subArraySum(arr,k);

    }
    
}
