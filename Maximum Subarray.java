class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0];
        int sum = 0;

        int left = 0;
        for(int right=0;right<nums.length;right++){
            sum += nums[right];
            if(sum > maxSum){
                maxSum = sum;
            }
            while(sum < 0 ){
                sum -= nums[left];
                left++;
            }

        }
        return maxSum;
       
    }
}
