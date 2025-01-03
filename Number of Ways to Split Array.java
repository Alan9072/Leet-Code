class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;

        long preSum = 0;
        long sum = 0;
        for(int val : nums){
            preSum += val;
        }
        for(int i=0;i<nums.length - 1;i++){
            sum += nums[i];
            preSum -= nums[i];
            if(sum >= preSum)count++;
        }
        return count;
    }
}
