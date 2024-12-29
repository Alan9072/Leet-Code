class Solution {
    public int fib(int n) {
        if(n == 0)return 0;
        int a = 0,b = 1,sum = 0;
        for(int i=2;i<n;i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return b + a;
    }
}
////////////////////////////////////////////////////////////
///TOP - DOWN // with memoization
class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        return fibonacci(n,dp);
    }
    public int fibonacci(int n,int[] dp){
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(dp[n] != -1)return dp[n];

        dp[n] = fibonacci(n - 1,dp) + fibonacci(n - 2,dp);
        return dp[n];
    }
}
