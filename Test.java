public class Test{

    public static void maxSubArray(int target,int nums[]){
        

        int maxSum=0;
        int windowSum=0;

        for(int i=0;i<target;i++){

            windowSum+=nums[i];
        }

        for(int j=target;j<nums.length;j++){

            windowSum +=nums[j]-nums[j-target];
        }

        if(windowSum > maxSum){
            maxSum=windowSum;
        }

         System.out.println(maxSum);
    }

   



}