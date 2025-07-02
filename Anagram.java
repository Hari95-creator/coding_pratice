import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {

    public static boolean anagramChecker(String fstring, String sString) {

        char fs[] = fstring.toCharArray();
        char sS[] = sString.toCharArray();

        Arrays.sort(fs);
        Arrays.sort(sS);

        if (fs.length == sS.length) {

            for (int i = 0; i < fs.length; i++) {

                if (fs[i] != sS[i]) {

                    return false;

                }

            }
        }

        return true;
    }

    public static void main(String args[]) {

        String firstString = "slient";
        String secondString = "listen";

        boolean isAnagram = anagramChecker(firstString, secondString);

        System.out.println(isAnagram);
    }

}
