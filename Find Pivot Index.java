class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<nums.length;i++){
            rightSum += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                rightSum -= nums[i];
                if(leftSum == rightSum)return i;
            }else{
                leftSum += nums[i - 1];
                rightSum -= nums[i];
                if(leftSum == rightSum)return i;
            }
        }
        return -1;
    }
}
