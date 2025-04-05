class Solution {
    int MOD = 1000000007;
    public int knightDialer(int n) {
        
        int[][] moves = {
                { 4, 6 }, // from 0
                { 6, 8 }, // from 1
                { 7, 9 }, // from 2
                { 4, 8 }, // from 3
                { 0, 3, 9 }, // from 4
                {}, // from 5
                { 0, 1, 7 }, // from 6
                { 2, 6 }, // from 7
                { 1, 3 }, // from 8
                { 2, 4 } // from 9"""
        };
        int[][] dp = new int[n][10];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int mainSum = 0;
        for(int i=0;i<=9;i++){
            mainSum = (mainSum + find(n-1,i,moves,dp)) % MOD;
        }
        return mainSum;
    }
    public int find(int rem,int digit,int[][] moves,int[][] dp){

        if(rem == 0)return 1;
        if(dp[rem][digit] != -1)return dp[rem][digit];

        int total = 0;
        for(int i=0;i<moves[digit].length;i++){
            int result = find(rem - 1,moves[digit][i],moves,dp);
            total = (total + result ) % MOD;
        }
        dp[rem][digit] = total;

        return total;

    }
}
