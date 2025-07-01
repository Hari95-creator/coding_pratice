public class MagicSquare {

    public static boolean magicSquareCheck(int n[][]) {

        int magicSum = 0;
        int squareLength = n.length;

        // first row
        for (int i = 0; i < squareLength; i++) {
            magicSum += n[0][i];
        }

        // row check
        for (int row = 1; row < squareLength; row++) {
            int rowSum = 0;

            for (int col = 0; col < squareLength; col++) {
                rowSum += n[row][col];
            }

            if (rowSum != magicSum) {
                return false;
            }
        }
        // col check
        for (int row = 0; row < squareLength; row++) {
            int colSum = 0;

            for (int col = 0; col < squareLength; col++) {
                colSum += n[row][col];
            }

            if (colSum != magicSum) {
                return false;
            }
        }

        // main diagonal

        int mainDiagonal = 0;
        for (int i = 0; i < squareLength; i++) {
            mainDiagonal += n[i][i];
        }

        if (mainDiagonal != magicSum) {
            return false;
        }

        // seondary Diagonal
        int secondaryDiagonal = 0;
        for (int i = 0; i < squareLength; i++) {

            secondaryDiagonal += n[i][squareLength - 1 - i];
        }

        if (secondaryDiagonal != magicSum) {
            return false;
        }

        return true;

    }

    public static void main(String args[]) {
        int arr[][] = {
                { 2, 7, 6 },
                { 9, 5, 1 },
                { 4, 3, 8 }
        };

        boolean isMagicSquare = magicSquareCheck(arr);

        System.out.println("Is Magic Square : " + isMagicSquare);
    }
}
