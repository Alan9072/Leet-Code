class Solution {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        int start = end;
        while(start > 0){
            start--;
            if(start + nums[start] >= end){
                end = start;
            }
        }
        return end == 0;
    }
}
