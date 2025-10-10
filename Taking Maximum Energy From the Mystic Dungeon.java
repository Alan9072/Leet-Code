class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] dp = new int[energy.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<energy.length;i++){
            max = Math.max(dfs(i,energy,k,dp),max);
        }
        return max;
    }
    public int dfs(int idx,int[] energy,int k,int[] dp){
        if(idx >= energy.length)return 0;

        if(dp[idx] != Integer.MIN_VALUE){
            return dp[idx];
        }

        return dp[idx] = energy[idx] + dfs(idx + k,energy,k,dp);
    }
}
