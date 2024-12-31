//////////////////////////Recursive Approach/////////////////////////
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int val = nums[0];
        nums[0] = 0;
        int case1 = robbed(dp,nums,nums.length - 1);
        Arrays.fill(dp,-1);
        nums[0] = val;
        int case2 = robbed(dp,nums,nums.length - 2);
        return Math.max(case1,case2);
    

    }
    public int robbed(int[] dp,int[] nums,int curr){
        if(curr < 0)return 0;
        if(dp[curr] != -1)return dp[curr];

        int take = nums[curr] + robbed(dp,nums,curr - 2);
        int non_take = robbed(dp,nums,curr - 1);

        dp[curr] = Math.max(take,non_take);
        return dp[curr];
    }
}
///////////////////////////Tabulation ///////////////////////////
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);
        int case1 = robbed(dp, nums, nums.length - 1, 1);

        Arrays.fill(dp, -1);
        int case2 = robbed(dp, nums, nums.length - 2, 0);
        return Math.max(case1, case2);

    }

    public int robbed(int[] dp, int[] nums, int curr, int end) {
        dp[curr] = nums[curr];
        for (int i = end; i <= curr; i++) {
            int take = nums[i];
            if (i - 2 >= end) {
                take += dp[i - 2];
            }
            int non_take = 0 ;
            if(i - 1 >= end) non_take += dp[i - 1];

            dp[i] = Math.max(take, non_take);
        }
        return dp[curr];

    }
}
