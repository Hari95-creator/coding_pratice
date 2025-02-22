import java.util.ArrayList;

public class PeakBinary {


    public static Integer peakElement(ArrayList<Integer> list){

        int left=0;
        int right=list.size()-1;

        while(left < right){

            int mid=left+(right-left)/2;
            
            if(list.get(mid) > list.get(mid+1)){

                right=mid;

            }else{

                left=mid+1;
            }

        }

        return list.get(left);

    }

    public static void main(String [] args){

        int arr[]={50,66,120,11,2,3};

        ArrayList<Integer> list=new ArrayList<>();
        for(int num :  arr){

            list.add(num);
        }

        Integer number=peakElement(list);

        System.out.println(number);

    }
    
}
