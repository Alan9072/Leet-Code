class Solution {
    public int rob(int[] nums) {
        
        int[] helper = new int[nums.length];
        for(int i=0;i<helper.length;i++){
            helper[i] = -1;
        }
        return robed(nums,helper,nums.length - 1);
    }
    public int robed(int[] nums,int[] helper,int index){
        if(index == 0){
            return nums[index];
        }
        if(index < 0)return 0;
        if(helper[index] != -1)return helper[index];

        int case1 = nums[index] + robed(nums,helper,index - 2);
        int case2 = robed(nums,helper,index - 1);
        helper[index] = Math.max(case1,case2);

        return Math.max(case1,case2);
    }
}
/////////////////////////////////////////////////////
//tabulation method 
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i=1;i<nums.length;i++){

            int take = nums[i];
            if(i > 1)take += dp[i - 2];
            int non_take = dp[i - 1];

            dp[i] = Math.max(take,non_take);
        }
        return dp[nums.length - 1];
    }
}
