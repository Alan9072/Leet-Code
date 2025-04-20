class Solution {
    public int maximumPossibleSize(int[] nums) {
        int count = 0;
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] > nums[i + 1]){
                count++;
                nums[i+1] = nums[i];
            }
            
        }
        return nums.length - count;
    }
}
