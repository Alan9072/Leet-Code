class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int rowLength = matrix[i].length;
            for(int j=0;j<matrix[i].length / 2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][rowLength - j - 1];
                matrix[i][rowLength - j - 1] = temp;
            }
        }
    }
}
