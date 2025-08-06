import java.util.ArrayList;
import java.util.List;

public class SortBaseOnSecondDigit {

    static List<Integer> sortBasedOnSecondDigit(List<Integer> numData){

        List<Integer> sortedList=new ArrayList<>();

        numData.sort((a,b) ->{

            int sortDigitA=a/10%10;//extract tens digit of first number
            int sortDigitB=b/10%10;//extract tens digit of second number

            return Integer.compare(sortDigitA,sortDigitB);
        });

        sortedList.addAll(numData);

        return sortedList;  
    }

    public static void main(String args[]){


        int numData[]={12,13,15,78,16};

        List<Integer> data=new ArrayList<>();

        for (int num : numData){

            data.add(num);
        }

        List<Integer> result=sortBasedOnSecondDigit(data);

        System.out.println("Sorted List Based on Second Digit: " + result);
    }

    
}
