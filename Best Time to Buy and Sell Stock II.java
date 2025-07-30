class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,prices,0,dp);
    }
    public int dfs(int idx,int[] prices,int state,int[][] dp){
        if(idx >= prices.length)return 0;
        if(dp[idx][state] != -1)return dp[idx][state];

        int buy = 0;
        int sell = 0;
        if(state == 0){
            buy = -prices[idx] + dfs(idx+1,prices,1,dp);
        }else{
            sell = prices[idx] + dfs(idx+1,prices,0,dp);
        }
        
        int skip = dfs(idx+1,prices,state,dp);

        return dp[idx][state] = Math.max(buy,Math.max(sell,skip));
        
    }
}
