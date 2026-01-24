class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int st = 0;
        int ed = nums.length - 1;

        int result = 0;
        while(st < ed){
            result = Math.max(result,nums[st] + nums[ed]);
            st++;
            ed--;
        }
        return result;
    }
}
