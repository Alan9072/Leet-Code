class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(prices,0,0,dp);
    }
    public int dfs(int[] prices,int state,int idx,int[][] dp){
        if(idx >= prices.length)return 0;

        if(dp[idx][state] != -1)return dp[idx][state];

        if(state == 0){
            int buy = -prices[idx] + dfs(prices,1,idx + 1,dp);
            int skip = dfs(prices,0,idx + 1,dp);
            return dp[idx][state] = Math.max(buy,skip);
        }else{
            int sell = prices[idx] + dfs(prices,0,idx + 2,dp);
            int skip = dfs(prices,state,idx + 1,dp);
            return dp[idx][state] = Math.max(sell,skip);
        }

    }
}
