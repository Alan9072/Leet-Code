class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;

        int left = 0;
        int sum = 0;
        for(int right = 0;right < nums.length; right++){

            sum += nums[right];

            if(sum == 0){
                total += right - left + 1;
            }

            while(sum != 0){
                sum -= nums[left];
                left++;
            }

        }
        return total;
    }
}
