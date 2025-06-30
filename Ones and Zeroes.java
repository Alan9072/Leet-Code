class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return dfs(0,strs,0,0,m,n,dp);
    }
    public int dfs(int idx,String[] strs,int rm,int rn,int m,int n,int[][][] dp){

        if(idx >= strs.length){
            return 0;
        }

        if(dp[idx][rm][rn] != -1)return dp[idx][rm][rn];

        int ones = 0;
        int zeroes = 0;
        for(int i=0;i<strs[idx].length();i++){
            if(strs[idx].charAt(i) == '0'){
                zeroes++;
            }else{
                ones++;
            }
        }

        int pick = 0;
        if(rm + zeroes <= m && rn + ones <= n){

            pick = 1 + dfs(idx + 1,strs,rm + zeroes,rn + ones,m,n,dp);
        }

        int notPick = dfs(idx + 1,strs,rm,rn,m,n,dp);

        return dp[idx][rm][rn] = Math.max(pick,notPick);
    }
}
