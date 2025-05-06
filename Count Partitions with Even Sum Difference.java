class Solution {
    public int countPartitions(int[] nums) {
        int prefix = 0;
        for(int val : nums){
            prefix += val;
        }
        int count = 0;
        int sum = 0;
        for(int i=0;i<nums.length - 1;i++){
            sum += nums[i];
            prefix -= nums[i];

            if(Math.abs(sum - prefix) % 2 == 0 )count++;
        }
        return count;
    }
}
