import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Com{

    public static String compression(String s){

        int count =0;
        int currentChar=s.charAt(0);
    
        StringBuilder compressedData=new StringBuilder();
    
        for (int i=0;i<s.length();i++){
    
            if(s.charAt(i)==currentChar){
    
                count++;
            }else{
    
                compressedData.append(currentChar).append(count);
                currentChar=s.charAt(i);
                count+=1;
            }
    
    
        }
    
        return compressedData.toString();
    
    }

    public static int pivotElement(ArrayList<Integer> pivotList) {

        int totalSum=0;
        for(int num : pivotList){
        
        
            totalSum+=num;
        
        }
        
        int leftSum=0;
        for(int i=0;i<pivotList.size();i++){
        
        
            if(leftSum==totalSum-leftSum-pivotList.get(i)){
        
                return i;
            }
            leftSum+=pivotList.get(i);
        }

    }

public static String compressed(String s){


    int count=0;
    char currentChar=s.charAt(0);

    StringBuilder compressedString=new StringBuilder();
    for(int i=0;i<s.length();i++){

        if(currentChar==s.charAt(i)){

            count ++;

        }
        else{

            compressedString.append(s.charAt(i)).append(count);
            currentChar=s.charAt(i);
            count+=1;

        }

        compressedString.append(s.charAt(i)).append(count);


    }


    return compressedString.toString();

}


public static int dup(ArrayList<Integer> list){


    HashSet<Integer> set=new HashSet<>();

    for(int num : list){

        if(!set.add(num)){
            return num;
        }
    }


    return -1;

}

public static Integer peak(ArrayList<Integer> lis){


    int left=0;
    int right=lis.size()-1;

    while(left<right){

        int mid=left+(right-left)/2;

        if(lis.get(mid)>lis.get(mid+1)){

            right=mid;

        }else{

            left=mid+1;
        }

        return lis.get(left);
    }




}




public static void main(String args[]){

    int arr[]={1,2,3,8,9};
    ArrayList<Integer> pivotArray=new ArrayList<>();
    for(int n:arr){

        pivotArray.add(n);

    }

    System.out.println(pivotElement(pivotArray));

    String input = "aabcccccaaa";
    System.out.println("Compressed string: " + compression(input));
}
    

}



