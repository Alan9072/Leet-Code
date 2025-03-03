class Solution {
    public int[] applyOperations(int[] nums) {
        int[] modifiedNums = new int[nums.length];
        int zeroCount = 0;
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        for (int num : nums) {
            if (num != 0) {
                modifiedNums[zeroCount++] = num;
            }
        }
        while (zeroCount < nums.length) {
            modifiedNums[zeroCount++] = 0;
        }

        return modifiedNums;
    }
}
