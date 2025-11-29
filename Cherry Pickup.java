class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];
        for(int[][][] arrs : dp){
            for(int[][] arr : arrs){
                for(int[] ar : arr){
                    Arrays.fill(ar,-1);
                }
            }
        }

        int val = dfs(0,0,0,0,grid,dp);
        return val == Integer.MIN_VALUE ? 0 : val;
    }
    public int dfs(int r1,int c1,int r2,int c2,int[][] grid,int[][][][] dp){
        int n = grid.length;
        if(r1 == n || r2 == n )return Integer.MIN_VALUE;
        if(c1 == n || c2 == n)return Integer.MIN_VALUE;
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1)return Integer.MIN_VALUE;
        if(dp[r1][c1][r2][c2] != -1)return dp[r1][c1][r2][c2];

        int maxsum = 0;
        if(grid[r1][c1] == 1 && grid[r2][c2] == 1){
            if(r1 == r2 && c1 == c2){
                maxsum +=1;
            }else{
                maxsum +=2;
            }
        }else if(grid[r1][c1] == 1 || grid[r2][c2] == 1){
            maxsum += 1;
        }

        if(r1 == n-1 && r2 == n-1 && c1 == n-1 && c2 == n-1)return maxsum;
        //down - down
        int a = dfs(r1+1,c1,r2+1,c2,grid,dp);
        //down - right
        int b = dfs(r1+1,c1,r2,c2+1,grid,dp);
        //right - down
        int c = dfs(r1,c1+1,r2+1,c2,grid,dp);
        //right - right
        int d = dfs(r1,c1+1,r2,c2+1,grid,dp);

        int sub = Math.max(a,Math.max(b,Math.max(c,d)));
        return dp[r1][c1][r2][c2] = sub == Integer.MIN_VALUE ? sub : maxsum + sub;
    }
}
