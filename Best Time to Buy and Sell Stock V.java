class Solution {
    static final long NEG_INF = Long.MIN_VALUE / 4;

    public long maximumProfit(int[] prices, int k) {
        long dp[][][] = new long[prices.length][k+1][3];
        for(long[][] sub : dp){
            for(long[] arr : sub){
                Arrays.fill(arr,-1);
            }
        }
        return dfs(0, k, prices, 0,dp);
    }

    public long dfs(int idx, int k, int[] prices, int turn,long [][][] dp) {

        if (k == 0) {
            if (turn == 0) return 0;
            return NEG_INF;
        }

        if (idx == prices.length) {
            if (turn == 0) return 0;
            return NEG_INF;
        }

        if(dp[idx][k][turn] != -1)return dp[idx][k][turn];

        long nT = NEG_INF;
        long sT = NEG_INF;

        if (turn == 0) {
            nT = -prices[idx] + dfs(idx + 1, k, prices, 1,dp); // buy
            sT =  prices[idx] + dfs(idx + 1, k, prices, 2,dp); // short sell
        }
        else if (turn == 1) {
            nT = prices[idx] + dfs(idx + 1, k - 1, prices, 0,dp); // sell
        }
        else {
            sT = -prices[idx] + dfs(idx + 1, k - 1, prices, 0,dp); // buy back
        }

        long skip = dfs(idx + 1, k, prices, turn,dp);

        return dp[idx][k][turn] = Math.max(skip, Math.max(nT, sT));
    }
}
