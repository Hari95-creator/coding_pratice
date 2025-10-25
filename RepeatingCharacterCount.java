import java.util.LinkedHashMap;
import java.util.Map;

public class RepeatingCharacterCount{

public static void charcterCount(String word){

    LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();

    for(char c : word.toCharArray()){

        charCountMap.put(c,charCountMap.getOrDefault(c,0)+1);
    }

    for(Map.Entry<Character,Integer> entry :charCountMap.entrySet()){

        if(entry.getValue()>1){

            System.out.println(entry.getKey());
        }


    }
}
public static void main(String[] args){

    String word="programming";

    charcterCount(word);


}
}