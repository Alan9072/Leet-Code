class Solution {
    public int longestSubsequence(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        String reversed = new StringBuilder(s).reverse().toString();
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        
        return dfs(0,reversed,dp,k,0,0);
    }
    public int dfs(int id1,String s,int[][] dp,int k,int id2,long sum){
        if(id1 >= s.length())return 0;
        
        long val = (s.charAt(id1) - '0') * (int)Math.pow(2,id2);

        if(dp[id1][id2] != -1)return dp[id1][id2];

        int take = 0;
        if(sum + val <= k){
            take = 1 + dfs(id1 + 1,s,dp,k,id2 + 1,sum + val);
        }
        int notTake = dfs(id1 + 1,s,dp,k,id2,sum);

        return dp[id1][id2] = Math.max(take,notTake);
    }
}
