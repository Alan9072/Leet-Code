//////////////////////Recursion with Memoization///////////////////
class Solution {
 
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return sum(0,0,grid,dp);
        
    }
    public int sum(int i,int j,int[][] grid,int[][] dp){
        if(i == grid.length || j == grid[0].length)return Integer.MAX_VALUE;
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return  grid[i][j];
        }
        if(dp[i][j] != -1){
            return  dp[i][j];
        }
        
        int left = sum(i,j+1,grid,dp);
        int bottom = sum(i+1,j,grid,dp);
        dp[i][j] = grid[i][j] +  Math.min(left,bottom);
        return dp[i][j];
    }
}

/////////////////////////////Tabulation ///////////////////////////////
class Solution {
 
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else{
                    int top = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if(i > 0){
                         top = dp[i - 1][j];
                    }
                    if(j > 0){
                         left = dp[i][j - 1];
                    }
                    dp[i][j] = grid[i][j] +  Math.min(top,left);
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
        
    }
}
