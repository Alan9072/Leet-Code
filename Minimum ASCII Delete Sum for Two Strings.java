class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<=s1.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(0,0,s1,s2,dp);
    }

    public int dfs(int i1,int i2,String s1,String s2,int[][] dp){
        if(i1 == s1.length() && i2 == s2.length())return 0;
        if(dp[i1][i2] != -1)return dp[i1][i2];

        if(i1 == s1.length()){
            int sum = 0;
            for(int i=i2;i<s2.length();i++){
                sum += (int) s2.charAt(i);
            }
            return sum;
        }
        if(i2 == s2.length()){
            int sum = 0;
            for(int i=i1;i<s1.length();i++){
                sum += (int) s1.charAt(i);
            }
            return sum;
        }

        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = dfs(i1 + 1,i2 + 1,s1,s2,dp);
        }else{
            int first = (int) s1.charAt(i1) + dfs(i1 + 1,i2,s1,s2,dp);
            int second = (int) s2.charAt(i2) + dfs(i1,i2 + 1,s1,s2,dp);
            return dp[i1][i2] = Math.min(first,second);

        }

    }
}
