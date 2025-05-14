class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                sum += nums[i];
            }else{
                if(nums[i] > nums[i - 1]){
                    sum += nums[i];
                }else{
                    
                    sum = 0;
                    sum += nums[i];
                }
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
