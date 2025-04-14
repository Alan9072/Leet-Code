class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp,-1);
        return find(nums,target,dp);
    }
    public int find(int[] nums,int target,int[] dp){
        if(target == 0)return 1;
        if(target < 0)return 0;

        if(dp[target] != -1)return dp[target];

        int total = 0;
        for(int i=0;i<nums.length;i++){
            int sum = find(nums,target - nums[i],dp);
            total += sum;
        }
        dp[target] = total;
        return dp[target];

    }
}
