class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        while(pointer < nums.length && nums[pointer] != 0){
            pointer++;
        }
        for(int i=pointer;i<nums.length;i++){
            if(nums[i] != 0){
                nums[pointer] = nums[i];
                nums[i] = 0;
                pointer++;
                
            }
        }
        
    }
}
