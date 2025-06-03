import java.util.ArrayList;

public class Test {

    public static Integer findPeak(ArrayList<Integer> nums){

        int left=0;
        int right=nums.size()-1;

        while(left<right){

            int mid=left+(right+left)/2;

            if(nums.get(mid)> nums.get(mid+1)){

                right=mid;

            }else{

                left=mid+1;
            }

        }


        return nums.get(left);


    }

    public static Integer pivotElement <ArrayList<Integer> pivot>{

        int totalSum=0;

        for(Integer num : pivot){

            totalSum+=num;
        }

        int leftSum=0;

        for(int i=0;i<pivot.size();i++){

            int rightSum=totalSum-leftSum-pivot.get(i);

            if(leftSum==rightSum){

                return i;
            }

            leftSum +=pivot.get(i);
        }

        return -1;


    }

    public static void main(String[] args){


        int arr[]={1,120,240,12,5};

        ArrayList<Integer> i=new ArrayList<>();

        for(Integer nums : arr ){

            i.add(nums);
        }

        Integer peak=findPeak(i);

        System.out.println(peak);


    }
    

}
