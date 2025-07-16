class Solution {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,s.length() - 1,s,dp);
    }
    public int dfs(int st,int ed,String s,int[][] dp){
        if(st >= ed)return 0;

        if(dp[st][ed] != -1)return dp[st][ed];

        if(s.charAt(st) == s.charAt(ed)){
            return dp[st][ed] =  dfs(st + 1,ed - 1,s,dp);
        }else{
            int leftM = 1 + dfs(st,ed - 1,s,dp);
            int rightM = 1 + dfs(st + 1,ed,s,dp);
            return dp[st][ed] = Math.min(leftM,rightM);
        }
    }
}
