class Solution {
    public int maxProfit(int k, int[] prices) {
        
    int[][][] dp = new int[prices.length][2][k];
        for (int[][] day : dp) {
            for (int[] arr : day) {
                Arrays.fill(arr, -1);
            }
        }
        return dfs(prices, 0, 0, 0, dp,k);
    }

    public int dfs(int[] prices, int trans, int idx, int state, int[][][] dp,int k) {
        if (idx >= prices.length || trans >= k)
            return 0;
        if (dp[idx][state][trans] != -1)
            return dp[idx][state][trans];

        if (state == 0) {
            //buy
            int buy = dfs(prices, trans, idx + 1, 1, dp,k) - prices[idx];
            int skip = dfs(prices, trans, idx + 1, state, dp,k);
            return dp[idx][state][trans] = Math.max(buy, skip);

        } else {
            //sell

            int sell = prices[idx] + dfs(prices, trans + 1, idx + 1, 0, dp,k);
            int skip = dfs(prices, trans, idx + 1, state, dp,k);
            return dp[idx][state][trans] = Math.max(sell, skip);
        }
    }
}
