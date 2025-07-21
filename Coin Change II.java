class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,amount,coins,dp);
    }
    public int dfs(int idx,int amount,int[] coins,int[][] dp){
        if(amount == 0)return 1;
        if(amount < 0)return 0;
        if(idx >= coins.length)return 0;

        if(dp[idx][amount] != -1)return dp[idx][amount];

        int take = dfs(idx,amount - coins[idx],coins,dp);

        int notTake = dfs(idx + 1,amount,coins,dp);

        return dp[idx][amount] = take + notTake;
    }
}
