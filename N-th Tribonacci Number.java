class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n + 3];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return dfs(n,dp);
    }
    public int dfs(int n,int[] dp){
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = dfs(n-3,dp) + dfs(n-2,dp) + dfs(n-1,dp);
    }
}
