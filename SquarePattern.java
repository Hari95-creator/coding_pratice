public class SquarePattern {

    public static void main(String args[]) {

        int rows = 5;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < rows; j++) {

                // for printing * at border
                if (i == 0 || i == rows - 1 || j == 0 || j == rows - 1) {

                    System.out.print("*  ");
                } else {

                    System.out.print("   ");
                }
            }
            //move to next
            System.out.println("\n");

        }

    }

}