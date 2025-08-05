class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int curr = dfs(i, j, dp, matrix);
                max = Math.max(curr, max);
            }
        }
        return max;
    }

    public int dfs(int i, int j, int[][] dp, int[][] matrix) {

        if (dp[i][j] != -1)
            return dp[i][j];
        int curr = matrix[i][j];

        int top = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > curr) {
            top = dfs(i - 1, j, dp, matrix);
        }
        int bottom = 0;
        if (i + 1 < matrix.length && matrix[i + 1][j] > curr) {
            bottom = dfs(i + 1, j, dp, matrix);
        }
        int left = 0;
        if (j - 1 >= 0 && matrix[i][j - 1] > curr) {
            left = dfs(i, j - 1, dp, matrix);
        }
        int right = 0;
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > curr) {
            right = dfs(i, j + 1, dp, matrix);
        }

        return dp[i][j] = 1 + Math.max(top, Math.max(bottom, Math.max(left, right)));

    }
}
