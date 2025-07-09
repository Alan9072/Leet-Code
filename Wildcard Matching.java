class Solution {
    public boolean isMatch(String s, String p) {
        Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, dp);
    }

    public boolean dfs(String s, String p, int idx1, int idx2, Boolean[][] dp) {
        if (idx2 == p.length()) {
            return idx1 == s.length();
        }

        if (idx1 == s.length()) {
            // Ensure the rest of pattern is only *
            while (idx2 < p.length() && p.charAt(idx2) == '*') {
                idx2++;
            }
            return idx2 == p.length();
        }

        if(dp[idx1][idx2] != null)return dp[idx1][idx2];


        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            return dp[idx1][idx2] = dfs(s, p, idx1 + 1, idx2 + 1,dp);
            
        } else if (p.charAt(idx2) == '*') {
            boolean skip = dfs(s, p, idx1, idx2 + 1,dp);
            boolean convert = dfs(s, p, idx1 + 1, idx2,dp);
            return dp[idx1][idx2] = skip || convert;
            
        } else {
            return false;
        }

    }
}
