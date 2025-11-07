import java.util.HashSet;
import java.util.Set;

public class RepeatingElementsInMultiple {

    public static void repeatingNumber(int arr1[],int arr2[],int arr3[]){

        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        Set<Integer> set3=new HashSet<>();

        for(int num : arr1){

            set1.add(num);
        }

        for(int num2 : arr2){

            set2.add(num2);
        }

        for(int num3 : arr3){

            set3.add(num3);
        }

        Set<Integer> commonInArray=new HashSet<>(set1);
        commonInArray.retainAll(set2);
        commonInArray.retainAll(set3);
        
        
        System.out.println("Common Elements "+commonInArray);


    }



    public static void main(String args[]){

        int arr1[]={1,2,4,5,6};
        int arr2[]={8,9,4,5,6};
        int arr3[]={10,12,4,5,6};

        repeatingNumber(arr1,arr2,arr3);
    }
    
}
