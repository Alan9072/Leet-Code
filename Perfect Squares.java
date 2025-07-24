class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }

        int[][] dp = new int[list.size()][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, list, n, dp);
    }

    public int dfs(int idx, List<Integer> list, int sum, int[][] dp) {
        if (sum == 0) return 0;
        if (idx >= list.size()) return Integer.MAX_VALUE;

        if (dp[idx][sum] != -1) return dp[idx][sum];

        int take = Integer.MAX_VALUE;
        if (sum - list.get(idx) >= 0) {
            int val = dfs(idx, list, sum - list.get(idx), dp);
            if (val != Integer.MAX_VALUE) {
                take = 1 + val;
            }
        }

        int notTake = dfs(idx + 1, list, sum, dp);

        dp[idx][sum] = Math.min(take, notTake);
        return dp[idx][sum];
    }
}
