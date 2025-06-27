class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);

        return find(n,dp);
    }
    public int find(int n,int[] dp){
        if(n <= 1)return 1;
        if(dp[n] != -1)return dp[n];

        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += find(i - 1,dp) * find(n - i,dp);
        }
        return dp[n] = sum;
    }
}
