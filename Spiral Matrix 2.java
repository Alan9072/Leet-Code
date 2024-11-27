class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int counter = 1;

        int rowSt = 0;
        int rowEd = n - 1;

        int colSt = 0;
        int colEd = n - 1;
        while (counter <= n*n) {
            /////////////// top row////////////////
            for (int i = rowSt; i < rowSt + 1; i++) {
                for (int j = colSt; j <= colEd; j++) {
                    result[i][j] = counter;
                    counter++;
                }
            }
            rowSt++;
            ////////////// right col ///////////////
            for (int i = colEd; i < colEd + 1; i++) {
                for (int j = rowSt; j <= rowEd; j++) {
                    result[j][i] = counter;
                    counter++;
                }
            }
            colEd--;
            /////////////// bottom row////////////////
            for (int i = rowEd; i < rowEd + 1; i++) {
                for (int j = colEd; j >= colSt; j--) {
                    result[i][j] = counter;
                    counter++;
                }
            }
            rowEd--;
            ////////////// right col ///////////////
            for (int i = colSt; i < colSt + 1; i++) {
                for (int j = rowEd; j >= rowSt; j--) {
                    result[j][i] = counter;
                    counter++;
                }
            }
            colSt++;
        }

        return result;
    }
}
