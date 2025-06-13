class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(dfs(0,i,matrix,dp),min);
        }
        return min;

    }
    public int dfs(int i,int j,int[][] matrix,int[][] dp){
        if(i >= matrix.length )return 0;
        if( j < 0 || j >= matrix.length)return Integer.MAX_VALUE;

        if(dp[i][j] != Integer.MAX_VALUE)return dp[i][j];

        int down = dfs(i + 1,j,matrix,dp);
        int left = dfs(i + 1,j - 1,matrix,dp);
        int right = dfs(i + 1,j + 1,matrix,dp);

        return dp[i][j] = Math.min(down,Math.min(left,right)) + matrix[i][j];
    }
}
