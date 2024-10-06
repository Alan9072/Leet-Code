class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;
        int rowmid = 0;
        while(left <= right){
            rowmid = ( left + right )/2;
            if(target < matrix[rowmid][0]){
                right = rowmid - 1;
            }
            else if(target > matrix[rowmid][0] && target > matrix[rowmid][matrix[0].length - 1]){
                left = rowmid + 1;
            }
            else{
                break;
            }
        }


        left = 0;
        right = matrix[rowmid].length - 1;
        while(left <= right){
            int middle = (left + right)/2;
            if(target > matrix[rowmid][middle]){
                left = middle + 1;
            }
            else if(target < matrix[rowmid][middle]){
                right = middle - 1;
            }
            else{
                return true;
            }
        }
    return false;

    }
}
