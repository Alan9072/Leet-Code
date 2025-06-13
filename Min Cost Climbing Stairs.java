class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(dfs(0,cost,dp),dfs(1,cost,dp));
    }
    public int dfs(int index,int[] cost,int[] dp){
        if(index >= cost.length)return 0;
        if(dp[index] != -1)return dp[index];

        int oneJump = dfs(index + 1,cost,dp) + cost[index];
        int twoJump = dfs(index + 2,cost,dp) + cost[index];

        return dp[index] = Math.min(oneJump,twoJump);

    }
}
