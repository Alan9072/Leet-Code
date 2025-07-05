class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        //dp with len and zero or one
        
        int[] dp = new int[high + 1];
        Arrays.fill(dp,-1);
        return dfs(0,low,high,zero,one,dp);
    }
    public int dfs(int len,int low,int high,int zero,int one,int[] dp){
        if(len > high)return 0;

        if(dp[len] != -1)return dp[len];

        int count = 0;
        if(len >= low && len <= high){
            count++;
        }
        int toZero = dfs(len + zero,low,high,zero,one,dp);

        int toOne = dfs(len + one,low,high,zero,one,dp);

        int MOD = 1000000007;
        return dp[len] = (toZero + toOne + count) % MOD;

    }
}
