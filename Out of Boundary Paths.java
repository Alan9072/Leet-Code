class Solution {
    int MOD = 1000000000 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for(int[][] arr : dp){
            for(int[] sub : arr){
                Arrays.fill(sub,-1);
            }
        }
        return dfs(m,n,maxMove,startRow,startColumn,dp);
    }
    public int dfs(int m, int n, int maxMove, int startRow, int startColumn,int[][][] dp){
        if(startRow < 0 || startRow >= m)return 1;
        if(startColumn < 0 || startColumn >= n)return 1;
        if(maxMove == 0)return 0;

        if(dp[startRow][startColumn][maxMove] != -1)return dp[startRow][startColumn][maxMove];

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        int count = 0;
        for(int i=0;i<4;i++){
            int newX = startRow + dx[i];
            int newY = startColumn + dy[i];

            count = (count + dfs(m,n,maxMove - 1,newX,newY,dp)) % MOD;
        }

        return dp[startRow][startColumn][maxMove] = count;
    }
}
