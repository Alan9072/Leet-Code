class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(i == nums.length - 1){
                max = Math.max(max,Math.abs(nums[i] - nums[0]));
            }else{
                max = Math.max(max,Math.abs(nums[i] - nums[i + 1]));
            }
        }
        return max;
    }
}
