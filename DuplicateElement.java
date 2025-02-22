import java.util.ArrayList;
import java.util.Collections;

public class DuplicateElement {

    public static Integer findDuplicate(ArrayList<Integer> list){

        int left=0;
        int right=list.size()-1;
        
        Collections.sort(list);

        while(left < right){

            int mid=left+(right-left)/2;

            if(mid < list.size()-1 && list.get(mid).equals(list.get(mid+1))){

                return list.get(mid);

            }else if(mid < list.size()-1 && list.get(mid) < list.get(mid+1)){

                right=mid;

            }else{

                left=mid+1;

            }

        }

        return -1;


    }

    public static void main(String[] args){

        int arr[]={10,1,120,1,5,0};

        ArrayList<Integer> list=new ArrayList<>();

        for(int num : arr){

            list.add(num);
        }

        Integer d=findDuplicate(list);

        System.out.println(d);



    }


    
}
