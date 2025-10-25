public class isPanagram(String data){

    String str=data.toLowercase();
    
    boolean[] letters = new boolean[26];

    for(char ch : str.toCharArray()){

        if(ch >= 'a' && ch<='z'){

            letters[ch - 'a'] = true;
        }
    }

            for (boolean present : letters) {
            if (!present) return false;
        }
        return true;

            public static void main(String[] args) {
        String test = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram(test)); 
    }



}
