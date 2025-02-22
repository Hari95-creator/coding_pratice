import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateUsignHashset {


    public static Integer findDuplicate(ArrayList<Integer> list){


        HashSet<Integer> set=new HashSet<>();

        for(int num : list){

            if(!set.add(num)){

                return num;
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
