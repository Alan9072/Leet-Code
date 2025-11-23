class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[1001][1001];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        dfs(0, 0, str1, str2, dp);
        return build(0, 0, str1, str2, dp);
    }

    public int dfs(int idx1, int idx2, String str1, String str2, int[][] dp) {
        if (idx1 == str1.length() && idx2 == str2.length()) {
            return 0;
        } else if (idx1 == str1.length()) {
            return str2.substring(idx2).length();
        } else if (idx2 == str2.length()) {
            return str1.substring(idx1).length();
        }

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + dfs(idx1 + 1, idx2 + 1, str1, str2, dp);
        } else {
            //idx1 up
            int sub1 = 1 + dfs(idx1 + 1, idx2, str1, str2, dp);

            //idx2 up
            int sub2 = 1 + dfs(idx1, idx2 + 1, str1, str2, dp);

            return dp[idx1][idx2] = sub1 < sub2 ? sub1 : sub2;
        }
    }

    public String build(int idx1, int idx2, String str1, String str2, int[][] dp) {
        if (idx1 == str1.length() && idx2 == str2.length())
            return "";
        else if (idx1 == str1.length())
            return str2.substring(idx2);
        else if (idx2 == str2.length())
            return str1.substring(idx1);

        if (str1.charAt(idx1) == str2.charAt(idx2)) {
            return str1.charAt(idx1) + build(idx1 + 1, idx2 + 1, str1, str2, dp);
        }

        int take1 = dp[idx1 + 1][idx2] == -1 ? Integer.MAX_VALUE : dp[idx1 + 1][idx2];

        int take2 = dp[idx1][idx2 + 1] == -1 ? Integer.MAX_VALUE : dp[idx1][idx2 + 1];

        if (take1 <= take2) {
            return str1.charAt(idx1) + build(idx1 + 1, idx2, str1, str2, dp);
        } else {
            return str2.charAt(idx2) + build(idx1, idx2 + 1, str1, str2, dp);
        }
    }
}
