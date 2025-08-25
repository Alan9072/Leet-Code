class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int idx = 0;

        boolean decider = true;
        int i=0;
        int j=0;
        while(true){
            if(decider){//top right direction
                while(i >= 0 && j < n){
                    result[idx] = mat[i][j];
                    idx++;
                    if(i == m -1 && j == n - 1)return result;
                    i--;
                    j++;
                }
                if(i+1 >= 0 && j < n){
                    i = i+1;
                }else if(i+2 >= 0 && j - 1 < n){
                    i = i+2;
                    j = j - 1;
                }
                decider = false;
            }else{//bottom right direction
                while(j >= 0 && i < m){
                    result[idx] = mat[i][j];
                    idx++;
                    if(i == m -1 && j == n - 1)return result;
                    j--;
                    i++;
                }
                if(j+1 >= 0 && i < m){
                    j = j+1;
                }else if(j+2 >= 0 && i - 1 < m){
                    j = j+2;
                    i = i - 1;
                }
                decider = true;
            }
        }
    }
}
