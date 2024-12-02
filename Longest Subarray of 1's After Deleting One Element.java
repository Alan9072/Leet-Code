class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0;

        int left = 0;
        for(int right = 0;right<nums.length;right++){
            if(nums[right] == 0)count++;
            if(count <= 1){
                max = Math.max(max,right - left);
            }
            while(count > 1){
                if(nums[left] == 0)count--;
                left++;
            }
        }
        return max ;
    }
}
