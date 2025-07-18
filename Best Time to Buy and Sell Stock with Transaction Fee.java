class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return dfs(prices,fee,0,0,dp);
    }
    public int dfs(int[] prices,int fee,int idx,int state,int[][] dp){
        if(idx >= prices.length)return 0;
        if(dp[idx][state] != -1)return dp[idx][state];

        if(state == 0){
            //buy
            int buy = dfs(prices,fee,idx + 1,1,dp) - prices[idx] - fee;
            int skip = dfs(prices,fee,idx + 1,state,dp);
            return dp[idx][state] = Math.max(buy,skip);

        }else{
            //sell

            int sell = prices[idx] + dfs(prices,fee,idx + 1,0,dp);
            int skip = dfs(prices,fee,idx + 1,state,dp);
            return dp[idx][state] = Math.max(sell,skip);
        }
    }
}
