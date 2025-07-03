import java.util.HashSet;

public class Substring {

    public static String checkSubString(String data) {

        char rStr[] = data.toCharArray();
        HashSet<Character> charStore = new HashSet<>();
        HashSet<Character> charSet = new HashSet<>();
        int count=0;

        for (int i = 0; i < rStr.length; i++){

            if (!charStore.equals(rStr[i])) {
                charStore.add(rStr[i]);
                count++;
            }

    }

    }

    public static void main(String args[]) {

        String repeatingSubstring = "aaBBBcd";

        System.out.println("Longest Substring " + checkSubstring(repeatingSubstring));
    }
}