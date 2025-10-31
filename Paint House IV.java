class Solution {
    public long minCost(int n, int[][] cost) {
        long dp[][][] = new long[n/2+1][4][4];
        for(long[][] arr : dp){
            for(long arr1[] : arr){
                Arrays.fill(arr1,-1);
            }
        }
        return dfs(cost,n,0,cost.length - 1,-1,-1,dp);
    }
    public long dfs(int[][] cost,int n,int st,int ed,int prev1,int prev2,long[][][] dp){
        if(st >= n/2) return 0;
        if(dp[st][prev1+1][prev2+1] != -1)return dp[st][prev1+1][prev2+1];
        
        long sum = Long.MAX_VALUE;
        for(int i=0;i<cost[st].length;i++){
            if(i == prev1)continue;
            for(int j=0;j<cost[ed].length;j++){
                if(j == prev2)continue;
                if(i == j)continue;
                int cost1 = cost[st][i];
                int cost2 = cost[ed][j];
                long lower = cost1 + cost2 + dfs(cost,n,st+1,ed-1,i,j,dp);
                sum = Math.min(sum,lower);
            }
        }
        return dp[st][prev1+1][prev2+1] = sum;
    }
}
