////////////////Recursion with memoization////////////////////////
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;

        int[][] dp = new int[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            Arrays.fill(dp[i],-1);
        }

        return path(0,0,obstacleGrid,dp);
        
    }
    public int path(int i,int j,int[][] obstacleGrid,int[][] dp){
        if(i == obstacleGrid.length || j == obstacleGrid[0].length || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
            return 1;
        }
        if(dp[i][j] != -1)return dp[i][j];

        int right = path(i,j+1,obstacleGrid,dp);
        int bottom = path(i+1,j,obstacleGrid,dp);
        dp[i][j] = right + bottom; 

        return right + bottom;
    }
}

//////////////////////Tabulation//////////////////////////
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int dp[][] = new int[rowLen][colLen];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                else if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[rowLen - 1][colLen - 1];
    }
}
