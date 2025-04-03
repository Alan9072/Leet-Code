class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = 0, maxD = 0,maxV = 0;
        for(int i=0;i<nums.length;i++){
            maxV = Math.max(maxV,maxD * nums[i]);
            max = Math.max(max,nums[i]);
            maxD = Math.max(maxD,max - nums[i]);
        }
        return maxV;
    }
}
