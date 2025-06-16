class Solution {
    public int longestPalindromeSubseq(String s) {
        int max = s.length();
        int[][] dp = new int[max][max];
        for (int i = 0; i < max; i++) {
            Arrays.fill(dp[i], -1);
        }
        String reversed = new StringBuilder(s).reverse().toString();
        return dfs(0, 0, s, reversed, dp);

    }

    public int dfs(int idx1, int idx2, String text1, String text2, int[][] dp) {

        if (idx1 == text1.length() || idx2 == text2.length())
            return 0;

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + dfs(idx1 + 1, idx2 + 1, text1, text2, dp);
        } else {
            dp[idx1][idx2] = Math.max(
                    dfs(idx1 + 1, idx2, text1, text2, dp),
                    dfs(idx1, idx2 + 1, text1, text2, dp));
        }

        return dp[idx1][idx2];
    }
    
}
