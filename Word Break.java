class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return possible(0, s, wordDict, dp);
    }

    public boolean possible(int index, String s, List<String> wordDict, Boolean[] dp) {
        if (index == s.length())
            return true;
        if (dp[index] != null)
            return dp[index];

        for (int i = 0; i < wordDict.size(); i++) {
            String curr = wordDict.get(i);
            if (index + curr.length() <= s.length()) {
                String sub = s.substring(index, index + curr.length());
                if (curr.equals(sub)) {
                    if (possible(index + curr.length(), s, wordDict, dp)) {
                        return dp[index] = true;
                    }
                }
            }
        }
        return dp[index] = false;
    }
}
