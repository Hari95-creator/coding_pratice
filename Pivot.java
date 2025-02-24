import java.util.ArrayList;
import java.util.Arrays;

public class Pivot {
    public static int findPivotIndex(ArrayList<Integer> pivotArray) {
     
        if (pivotArray == null || pivotArray.isEmpty()) {
            return -1;
        }

   
        int totalSum = 0;

        for (Integer num : pivotArray) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < pivotArray.size(); i++) {
            
            int rightSum = totalSum - leftSum - pivotArray.get(i);
            if (leftSum == rightSum) {
                return i; 
            }
            leftSum += pivotArray.get(i); 
        }

        return -1; 
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 7, 3, 6, 5, 6};

        ArrayList<Integer> pivotArray = new ArrayList<>(Arrays.asList(arr));
        
        System.out.println("Pivot Index: " + findPivotIndex(pivotArray));
    }
}