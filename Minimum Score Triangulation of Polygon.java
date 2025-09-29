class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,values.length - 1,values,dp);
    }
    public int dfs(int st,int ed,int[] values,int[][] dp){

        if(dp[st][ed] != -1)return dp[st][ed];

        int min = Integer.MAX_VALUE;
        for(int i=st + 1;i<ed;i++){
            int cost = (values[st] * values[i] * values[ed]) + dfs(st,i,values,dp) + dfs(i,ed,values,dp);
            min = Math.min(min,cost);
        }

        return dp[st][ed] = (min == Integer.MAX_VALUE) ? 0 : min;
    }
}
