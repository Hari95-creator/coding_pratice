import java.util.ArrayList;

public class Peak {

    public static Integer findPeakElement(ArrayList<Integer> list){

            
        int n=list.size();

        //single element
        if(n==1){

            return list.get(0);
        }

        //first element
        if(list.get(0) >= list.get(1)){

            return list.get(0);
        }

        //last element
        if(list.get(n-1) >= list.get(n-2)){

            return list.get(n-1);
        }

        //middel elment

        for(int i=1; i<n-1 ;i++){

            if(list.get(i) >= list.get(i-1) && list.get(i) >=list.get(i+1)){

                return list.get(i);
            }
        }

        return -1;


    }

    public static void main(String[] args){

        int arr[]={54,11,24,13      };

        ArrayList<Integer> list=new ArrayList<>();

        for(int num : arr){

            list.add(num);

        }

        Integer peakElement=findPeakElement(list);
        System.out.println(peakElement);


    }

}