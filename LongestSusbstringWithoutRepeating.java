import java.util.HashSet;

public class LongestSusbstringWithoutRepeating {

    //sliding window approach
    // in xliding window it has two point sart( left ) and end (right )
    
    public static Integer findLongestSubstring(String word){

        HashSet<Character> charSet=new HashSet<>();

        int maxLength=0;
        int left=0;

        for(int right=0; right<word.length();right++){

            char currentChar=word.charAt(right);

            //this will remove  to shrink the window from left to right 
            while(charSet.contains(currentChar)){

                charSet.remove(word.charAt(left));
                left++;
            }

            charSet.add(currentChar);
            maxLength=Math.max(maxLength,right-left+1);
        }

        return maxLength;


    }

    public static void main(String[] args){


        String s="aaBBcd";

        Integer count=findLongestSubstring(s);

        System.out.println("Length of longest substring without repeating characters: " + count);

    }
    
}