class Solution {
    public int maxProfit(int[] prices) {

        int[][][] dp = new int[prices.length][2][3];
        for (int[][] day : dp) {
            for (int[] arr : day) {
                Arrays.fill(arr, -1);
            }
        }
        return dfs(prices, 0, 0, 0, dp);
    }

    public int dfs(int[] prices, int trans, int idx, int state, int[][][] dp) {
        if (idx >= prices.length || trans >= 2)
            return 0;
        if (dp[idx][state][trans] != -1)
            return dp[idx][state][trans];

        if (state == 0) {
            //buy
            int buy = dfs(prices, trans, idx + 1, 1, dp) - prices[idx];
            int skip = dfs(prices, trans, idx + 1, state, dp);
            return dp[idx][state][trans] = Math.max(buy, skip);

        } else {
            //sell

            int sell = prices[idx] + dfs(prices, trans + 1, idx + 1, 0, dp);
            int skip = dfs(prices, trans, idx + 1, state, dp);
            return dp[idx][state][trans] = Math.max(sell, skip);
        }
    }
}
