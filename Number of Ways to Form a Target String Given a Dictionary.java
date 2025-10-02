class Solution {
    int MOD = 1000000007;
    public int numWays(String[] words, String target) {
        
        int[][] dp = new int[1001][1001];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int[][] freq = new int[26][words[0].length()];
        for (String w : words) {
            for (int j = 0; j < words[0].length(); j++) {
                freq[w.charAt(j) - 'a'][j]++;
            }
        }
        
        return dfs(0, target, freq, 0, dp);
    }

    public int dfs(int idx, String target, int[][] freq, int idx2, int[][] dp) {
        if (idx == target.length())
            return 1;

        if(dp[idx][idx2] != -1)return dp[idx][idx2];
        char need = target.charAt(idx);

        int count = 0;

        int[] arr = freq[need - 'a'];
        for (int j = idx2; j < arr.length; j++) {
                if (arr[j] > 0) {
                    count = (int)((count + (long)arr[j] * dfs(idx + 1, target, freq, j + 1, dp)) % MOD);
                }
            }

        return dp[idx][idx2] = count;
    }
}
