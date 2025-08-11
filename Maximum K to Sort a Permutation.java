class Solution {
    public int sortPermutation(int[] nums) {
        int val = 0;
        int pos = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i){
                val = nums[i];
                pos = i;
                break;
            }
        }

        for(int i=pos + 1;i<nums.length;i++){
            if(nums[i] != i){
                val = val & nums[i];
            }
        }
        return val;
    }
}
