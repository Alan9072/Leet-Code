class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())return false;
        Boolean[][][] dp = new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        // for(int i=0;i<s1.length();i++){
        //     for(int j=0;j<s2.length();j++){
        //         for(int k=0;k<s3.length();k++){
        //             dp[i][j][k] = null;
        //         }
        //     }
        // }
        return dfs(0,s1,0,s2,0,s3,dp);
    }
    public boolean dfs(int i,String s1,int j,String s2,int k,String s3,Boolean[][][] dp){
        if(i == s1.length() && j == s2.length() && k == s3.length())return true;

        if(dp[i][j][k] != null)return dp[i][j][k];

        // if(i == s1.length()){
        //     if( k == s3.length() && j != s2.length())return false;
        //     if( j == s2.length() && k != s3.length())return false;
        // }
        // if(j == s2.length()){
        //     if( k == s3.length() && i != s1.length())return false;
        //     if( i == s1.length() && k != s3.length())return false;
        // }

        boolean first = false;
        boolean second = false;

        //first string
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            first = dfs(i+1,s1,j,s2,k+1,s3,dp);
        }

        //second string
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            second = dfs(i,s1,j+1,s2,k+1,s3,dp);
        }

        return dp[i][j][k] = first || second;

    }
}
