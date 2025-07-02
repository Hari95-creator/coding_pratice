public class ReverseString{

    public static void reverseCheck(String name){

        String reverse="";
        char str[]=name.toCharArray();

        for(int i=str.length-1;i>=0;i--){

            reverse+=str[i];
        }

        System.out.println(reverse);
    }


    public static void main(String args[]){

        String name="Harikrishnan";
        reverseCheck(name);
    }
}