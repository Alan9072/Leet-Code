class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        int count = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    count += dfs(i,j,matrix,dp);
                }
            }
        }
        return count;
    }
    public int dfs(int i,int j,int[][] matrix,int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int right = dfs(i,j+1,matrix,dp);
        int diagonal = dfs(i+1,j+1,matrix,dp);
        int down = dfs(i+1,j,matrix,dp);

        return dp[i][j] = 1 + Math.min(right,Math.min(diagonal,down));
    }
}
