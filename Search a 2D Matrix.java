class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;
        while(left <= right){
            mid = ( left + right )/2;
            if(target < matrix[mid][0]){
                right = mid - 1;
            }
            else if(target > matrix[mid][0] && target > matrix[mid][matrix[0].length - 1]){
                left = mid + 1;
            }
            else{
                break;
            }
        }


        left = 0;
        right = matrix[mid].length - 1;
        while(left <= right){
            int middle = (left + right)/2;
            if(target > matrix[mid][middle]){
                left = middle + 1;
            }
            else if(target < matrix[mid][middle]){
                right = middle - 1;
            }
            else{
                return true;
            }
        }
    return false;

    }
}
