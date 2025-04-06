class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return longest(nums,0,dp,Integer.MIN_VALUE);
    }
    public int longest(int[] nums,int index,int[] dp,int prev){
        if(index == nums.length)return 0;
        if(dp[index] != -1)return dp[index];

        int longest = 0;
        for(int i=index;i<nums.length;i++){
            int val = nums[i];
            if(val > prev){
               int value =  longest(nums,i + 1,dp,val);
               longest = Math.max(longest,value + 1);
            }
        }
        dp[index] = longest;
        return longest;
    }
}
