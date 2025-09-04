class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid[0].length][grid[0].length][grid.length];
        for(int[][] arr : dp){
            for(int[] arr1 : arr){
                Arrays.fill(arr1,-1);
            }
        }
        return dfs(0,grid[0].length - 1,0,grid,dp);
    }
    public int dfs(int c1,int c2,int r,int[][] grid,int[][][] dp){
        if(c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length)return 0;
        if(r == grid.length - 1){
            return grid[r][c1] + grid[r][c2];
        }

        if(dp[c1][c2][r] != -1)return dp[c1][c2][r];

        int[] cD = {-1,0,1};

        int max = 0;
        for(int i=0;i<cD.length;i++){
            int c1New = c1 + cD[i];

            for(int j=0;j<cD.length;j++){
                int c2New = c2 + cD[j];

                if(c1New == c2New)continue;

                max = Math.max(dfs(c1New,c2New,r + 1,grid,dp),max);
            }
        }
        return dp[c1][c2][r] = max + grid[r][c1] + grid[r][c2];

    }
}
