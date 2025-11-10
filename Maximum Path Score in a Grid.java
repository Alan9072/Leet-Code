
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k+1];
        for(int[][] arr : dp){
            for(int[] ar : arr){
                Arrays.fill(ar,-2);
            }
        }
        return dfs(0,0,grid,k,dp);
    }
    public int dfs(int idx1,int idx2,int[][] grid,int k,int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;
        
        if(idx1 >= n || idx2 >= m)return -1;
        if(grid[idx1][idx2] > 0 && k <= 0)return -1;
        if (idx1 == n - 1 && idx2 == m - 1) {
            if (grid[idx1][idx2] > 0 && k <= 0) return -1;

            return grid[idx1][idx2];
        }
        
        if(dp[idx1][idx2][k] != -2)return dp[idx1][idx2][k];    

        int score = 0;
        int newK = k;
        if(k > 0 && grid[idx1][idx2] > 0){
            score += grid[idx1][idx2];
            newK--;
        }

        int right = dfs(idx1,idx2+1,grid,newK,dp);
        int down = dfs(idx1+1,idx2,grid,newK,dp);

        return dp[idx1][idx2][k] = Math.max(right,down) == -1 ? -1 : score + Math.max(right,down);
        
    }
}
