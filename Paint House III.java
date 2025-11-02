class Solution {
    static final long INF = (long) 1e15;
    Long[][][] dp;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp = new Long[m][n + 1][target + 1];
        long ans = dfs(0, houses, cost, target, 0, 0, n);
        return ans >= INF ? -1 : (int) ans;
    }

    public long dfs(int idx, int[] houses, int[][] cost, int target, int cmp, int prev, int n) {
        if (cmp > target) return INF;
        if (idx == houses.length) return cmp == target ? 0 : INF;
        if (dp[idx][prev][cmp] != null) return dp[idx][prev][cmp];

        long minC = INF;

        if (houses[idx] > 0) {
            int newCmp = cmp + ((houses[idx] != prev) ? 1 : 0);
            minC = dfs(idx + 1, houses, cost, target, newCmp, houses[idx], n);
        } else {
            for (int i = 1; i <= n; i++) {
                int newCmp = cmp + ((i != prev) ? 1 : 0);
                long curr = cost[idx][i - 1] + dfs(idx + 1, houses, cost, target, newCmp, i, n);
                minC = Math.min(minC, curr);
            }
        }

        return dp[idx][prev][cmp] = minC;
    }
}
