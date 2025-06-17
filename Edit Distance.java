class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() > 0 && word2.length() == 0)return word1.length();
        if(word2.length() > 0 && word1.length() == 0)return word2.length();
        int max = Math.max(word1.length(),word2.length());
        int[][] dp = new int[max][max];

        for(int i=0;i<max;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(word1,word2,0,0,dp);
    }

    public int dfs(String w1, String w2, int i, int j, int[][] dp) {
        if (i == w1.length())
            return w2.length() - j; // insert remaining
        if (j == w2.length())
            return w1.length() - i; // delete remaining

        if (dp[i][j] != -1)
            return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = dfs(w1, w2, i + 1, j + 1, dp); // no operation
        } else {
            int insert = 1 + dfs(w1, w2, i, j + 1, dp);
            int delete = 1 + dfs(w1, w2, i + 1, j, dp);
            int replace = 1 + dfs(w1, w2, i + 1, j + 1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

}
