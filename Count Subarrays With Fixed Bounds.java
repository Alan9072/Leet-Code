class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        int min = -1;
        int max = -1;
        int left = 0;
        for(int right = 0;right < nums.length;right++){
            int curr = nums[right];

            if(curr < minK || curr > maxK){
                min = -1;
                max = -1;
                left = right + 1;
            }

            if(curr == minK){
                min = right;
            }

            if(curr == maxK){
                max = right;
            }

            if (min != -1 && max != -1) {
                count += Math.min(min, max) - left + 1;
            }
        }
        return count;
    }
}
