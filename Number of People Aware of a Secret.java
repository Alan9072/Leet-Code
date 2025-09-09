class Solution {
    int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return dfs(1,delay,forget,n,dp);
    }

    public int dfs(int day,int delay,int forget,int n,int[] dp){
        if(day > n)return 0;
        if(dp[day] != -1)return dp[day];

        int st = day + delay;
        int ed = day + forget;

        int sum = 0;
        for(int i=st;i<ed;i++){
            sum = (sum + dfs(i,delay,forget,n,dp)) % MOD;
        }

        if(day > n - forget){
            sum = (sum + 1) % MOD;
        }

        return dp[day] = sum;
    }
}
