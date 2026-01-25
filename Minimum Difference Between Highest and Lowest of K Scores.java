class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        if(k == 1)return 0;

        int result = Integer.MAX_VALUE;
        int limit = 0;
        for(int i=k-1;i<nums.length;i++){
            result = Math.min(nums[i] - nums[limit],result);
            limit++;
        }
        return result;
    }
}
