class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    max = Math.max(dfs(i,j,matrix,dp),max);
                }
            }
        }
        return max * max;
    }
    public int dfs(int i,int j,char[][] matrix,int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0')return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int down = dfs(i + 1,j,matrix,dp);
        int diagonal = dfs(i + 1,j + 1,matrix,dp);
        int right = dfs(i,j + 1,matrix,dp);
        

        //main part 
        dp[i][j] = Math.min(down,Math.min(diagonal,right)) + 1;
        //for understanding in detail, do it on a 3x3 full 1 matrix .

        return dp[i][j];
    }
}
