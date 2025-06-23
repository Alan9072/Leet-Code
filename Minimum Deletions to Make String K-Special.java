class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            freq[curr - 'a']++;
        }

        Arrays.sort(freq);
        int start = 0;
        while (start < 26 && freq[start] == 0) {
            start++;
        }
        int end = 25;

        int[][] dp = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(start, end, dp, freq, k);
    }

    public int dfs(int start, int end, int[][] dp, int[] freq, int k) {
        if (start == end)
            return 0;
        if (freq[end] - freq[start] <= k)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        return dp[start][end] = Math.min(freq[start] + dfs(start + 1, end, dp, freq, k),
                freq[end] - freq[start] - k + dfs(start, end - 1, dp, freq, k));

    }
}
