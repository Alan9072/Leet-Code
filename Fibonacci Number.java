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
///TOP - DOWN  recursion// with memoization
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
/////////////////////////////////////////////////////////////////
////Bottom - Up // tabulation
class Solution {
    public int fib(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
/////////////////////////////////////////////////////////////////
///bottom - up with space O(1);
class Solution {
    public int fib(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        int sol = 0;

        int prev2 = 0;
        int prev = 1;
        for(int i=2;i<=n;i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
            if(i == n)sol = curr;
        }
        return sol;
    }
}
