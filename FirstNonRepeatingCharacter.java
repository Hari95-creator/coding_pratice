public class FirstNonRepeatingCharacter {

    public static char firstNonRepeatingCharacter(String data){


        //here it will take ascII occurrences
        int occurrenceCount[]=new int[256];

        for(int i=0;i<data.length();i++){

            occurrenceCount[data.charAt(i)]++;      
        }

        //find Non Repeating character
         for(int i=0;i<data.length();i++){

            if(occurrenceCount[data.charAt(i)]==1){

                return data.charAt(i);

            }
         }
         return '-';
        }


        public static char repeatingCharacter(String data){

            int occurenceCount[]=new int [256];

            for(int i=0;i<data.length();i++){

                occurenceCount[data.charAt(i)]++;
            }

            for(int i=0;i<data.length();i++){

                if(occurenceCount[data.charAt(i)] >1){

                    return data.charAt(i);
                }
            }

            return'-';
        }


        public static void main(String args[]){

            String word="SWISS";

            char result=firstNonRepeatingCharacter(word);

            char result2=repeatingCharacter(word);

            System.out.println("First Non Repeating "+ result);

            System.out.println(" First Repeating "+ result2);
        }
    
}
