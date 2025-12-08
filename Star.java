public class Star {

    public static void printStar(){

        int size=5;

        for(int i=0;i<=size;i++){

            for(int j=0;j<i;j++){
            
                System.out.print("*");
            }

            System.out.println("\n");
        }


        for(int f=1;f<size;f++){
            for(int g=1;g<=size-1;g++){

                System.out.print(" ");
            }

            for(int g=0;g<=2*f-1;g++){

                System.out.print("*");
            }
            System.out.print("");
        }

    }

    public static void main(String args[]){
        printStar();
    }
    
}
