import java.util.HashSet;

public class Susbstring {

    public static void sTest(String word) {

        int left = 0;
        int maxLength = 0;
        int startIndex = 0;

        HashSet<Character> charStore = new HashSet<>();

        for (int right = 0; right < word.length(); right++) {

            char currentChar = word.charAt(right);

            while (charStore.contains(currentChar)) {

                charStore.remove(word.charAt(left));
                left++;
            }

            charStore.add(currentChar);

            if (right-left + 1 > maxLength) {

                maxLength = right-left + 1;
                startIndex = left;
            }
        }

        

        String unique = word.substring(startIndex, startIndex+maxLength);

        System.out.println("Unique Substring with longest repeating "+unique+"( Length "+maxLength+")");

    }

    public static void main(String args[]) {

        String wd = "aabcabcbb";
        sTest(wd);
    }

}