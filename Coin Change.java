class Solution {

    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-2);
        Arrays.sort(coins);
        coin(coins,amount,dp);
        return dp[amount] == -1 ? -1 : dp[amount]; // Fixing incorrect return value

    }
    public int coin(int[] coins,int amount,int[] dp){
        if(amount < 0)return -1;

        if(amount == 0){
            return 0;
        }

        if(dp[amount] != -2)return dp[amount];


        int minSteps = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int val = coin(coins,amount - coins[i],dp); 
            if(val >= 0){
                minSteps = Math.min(minSteps,val + 1);
            }
        }

        dp[amount] = (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
        return dp[amount];
        
    }
}

/////////////////////////////Recursion /(Not work)//////////////////////////////////
class Solution {

    public int coinChange(int[] coins, int amount) {
        if(amount <= 0)return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        Arrays.sort(coins);
        coin(coins,amount,dp);
        return dp[amount] == -1 ? -1 : dp[amount]; // Fixing incorrect return value

    }
    public int coin(int[] coins,int amount,int[] dp){
        if(amount < 0)return -1;

        if(amount == 0){
            return 0;
        }

        if(dp[amount] != -1)return dp[amount];


        int minSteps = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int val = coin(coins,amount - coins[i],dp); 
            if(val >= 0){
                minSteps = Math.min(minSteps,val + 1);
            }
        }

        dp[amount] = (minSteps == Integer.MAX_VALUE) ? -1 : minSteps; // Fixing return condition
        return dp[amount];
        
    }
}
