class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length == 1)return nums[0];
        int length = nums.length - 1;
        while(length>0){
            
            for(int i = 0;i<length;i++){
                nums[i] = (nums[i] + nums[i+1])%10;
            }
            length--;
        }
        return nums[0];
    }
}
