class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    max = Math.max(max,(long)(nums[i] - nums[j])*nums[k]);
                }
            }
        }
        return max < 0 ? 0 : max;
    }
}
