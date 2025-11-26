class Solution {
    int MOD = 1000000000 + 7;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        for(int[][] arr : dp){
            for(int[] sub : arr){
                Arrays.fill(sub,-1);
            }
        }
        return dfs(0,0,0,grid,k,dp);
    }
    public int dfs(int x,int y,int mod,int[][] grid,int k,int[][][] dp){
        if(x >= grid.length || y >= grid[0].length)return 0;
        int nMod = (mod + (grid[x][y] % k)) % k;

        if(x == grid.length - 1 && y == grid[0].length - 1){
            if(nMod == 0)return 1;
            return 0;
        }

        if(dp[x][y][mod] != -1)return dp[x][y][mod];

        
        int right = dfs(x,y+1,nMod,grid,k,dp);
        int down = dfs(x+1,y,nMod,grid,k,dp);

        return dp[x][y][mod] =  (right + down) % MOD;
    }
}
