class Solution {
    static final int MOD = 1000000007;
    public int numberOfWays(int n, int x) {
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(1,n,x,n,dp);
    }
    public int dfs(int idx,int sum,int x,int n,int[][] dp){
        if(sum == 0)return 1;
        if(sum < 0 || idx > n)return 0;

        if(dp[idx][sum] != -1)return dp[idx][sum];

        int take = dfs(idx + 1,sum - (int)Math.pow(idx,x),x,n,dp);

        int notTake = dfs(idx + 1,sum,x,n,dp);

        return dp[idx][sum] = (( take + notTake) % MOD);
    }
}
