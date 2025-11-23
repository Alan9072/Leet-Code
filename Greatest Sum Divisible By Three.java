class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,0,nums,dp);
    }
    public int dfs(int idx,int mod,int[] nums,int[][] dp){
        if(idx == nums.length){
            if(mod == 0) return 0;
            else return Integer.MIN_VALUE;
        }

        if(dp[idx][mod] != -1)return dp[idx][mod];
        
        int take = nums[idx] + dfs(idx+1,(mod + nums[idx] % 3) % 3,nums,dp);

        int notTake =  dfs(idx+1,mod,nums,dp);

        return dp[idx][mod] = Math.max(take,notTake);
    }
}
