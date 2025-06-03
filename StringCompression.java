public class StringCompression {                                                

    public static String compressString(String s){

        int count =0;
        char currentChar=s.charAt(0);
        StringBuilder compressed=new StringBuilder();

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == currentChar){

                count++;
                
            }else{

                compressed.append(currentChar).append(count);
                currentChar=s.charAt(i);
                count=1;

            }


        }


        return compressed.toString();


    }


    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println("Compressed string: " + compressString(input));
    }
    
}
