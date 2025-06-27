class Solution {
    public int numDecodings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,s,dp,"",0);
    }
    public int dfs(int idx,String s,int[][] dp,String rem,int start){
        if(idx < s.length() && Integer.parseInt(rem + s.charAt(idx)) > 26)return 0;
        if(idx < s.length() && rem.equals("") && s.charAt(idx) == '0')return 0;

        if(idx >= s.length()){
            if(rem.equals(""))return 1;
            else{
                return 0;
            }
        }
        if(dp[idx][start] != -1)return dp[idx][start];
        
        int convert = dfs(idx + 1,s,dp,"",idx + 1);

        int take = dfs(idx + 1,s,dp,rem + s.charAt(idx),idx);

        return dp[idx][start] = convert + take;
    }
}
