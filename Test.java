import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static Integer Duplicate(List<Integer> num){

        int left=0;
        int right=num.size()-1;

        Collections.sort(num);

        while(left<right){

            int mid=left+(right-left)/2;

            if(num.get(mid).equals(num.get(mid+1))){

                return num.get(mid);
            }else if(num.get(mid)> num.get(mid+1)){

                right=mid;
            }else{
                left=mid+1;
            }
        }

        return -1;

    }

    public static Integer HashD(List<Integer> num){

        Set<Integer> n2=new HashSet<>();

        for(int obj : num){

            if(!n2.add(obj)){
                return obj;
            }
        }

        return -1;

    }

    public static void main(String srgs[]){


        int arr[]={10,1,120,1,5,0};

        List<Integer> num=new ArrayList<>();

        for(Integer nObj: arr){

            num.add(nObj);
        }

        System.out.println(Duplicate(num));
        System.out.println(HashD(num));



    }

}
