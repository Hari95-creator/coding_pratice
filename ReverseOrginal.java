public class ReverseOrginal {

    public static void reverseString(String name) {

        int left = 0;
        int right = name.length() - 1;

        String reverse = "";

        char str[] = name.toCharArray();

        while (left < right) {

            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }

        for (int i = 0; i < str.length; i++) {
            reverse += str[i];
        }

        System.out.println(reverse);

    }

    public static void reverseCharwise(char str[]) {

        int left = 0;
        int right = str.length - 1;

        while (left < right) {

            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;

        }

        System.out.println(str);
    }

    public static void main(String args[]) {

        String name = "Athira";
        reverseString(name);

        char str[] = { 'H', 'A', 'R', 'I' };

        reverseCharwise(str);

    }
}