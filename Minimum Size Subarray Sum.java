class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int minLength = nums.length + 1;
        int sum = 0;
        int left = 0;

        for(int right=0;right<nums.length;right++){
            sum+=nums[right];

            while(sum >= target){
                minLength = Math.min(right - left + 1,minLength);
                sum-=nums[left];
                left++;
            }
           
        }
        return (minLength == nums.length + 1 ? 0 : minLength);
    }
}
