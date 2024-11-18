class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int i=0;
        int j=matrix[0].length - 1;

        while(i < m && i >= 0 && j >= 0){
            int elem = matrix[i][j];
            if(elem == target){
                return true;
            }else if(elem < target){
                i++;
            }else{
                j--;
            }
            

        }
        return false;

    }
}
