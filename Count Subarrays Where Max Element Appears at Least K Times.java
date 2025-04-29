class Solution {
    public long countSubarrays(int[] nums, int k) {
        long result = 0;
        int max = -1;
        for(int val : nums){
            max = Math.max(val,max);
        }

        int count = 0;
        int left = 0;
        for(int right = 0;right < nums.length; right++){
            if(nums[right] == max)count++;

            while(count >= k){
                result += nums.length - right;

                if(nums[left] == max){
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}
