class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[21][21];
        for(int i=0;i<=20;i++){
            Arrays.fill(dp[i],null);
        }
        return dfs(s, p, 0, 0, dp);
    }

    public boolean dfs(String s, String p, int i, int j, Boolean[][] dp) {
        // If pattern consumed
        if (j == p.length()) {
            return i == s.length();
        }

        if(dp[i][j] != null)return dp[i][j];

        // Check if current char matches
        boolean match = (i < s.length()) &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // If next char in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two choices:
            // - skip current pattern char + '*'
            // - or consume one matching char and stay on same pattern char
            return dp[i][j] =  dfs(s, p, i, j + 2,dp) ||
                   (match && dfs(s, p, i + 1, j ,dp));
        } else {
            // If chars match, move both forward
            return dp[i][j] =  match && dfs(s, p, i + 1, j + 1, dp);
        }
    }
}
