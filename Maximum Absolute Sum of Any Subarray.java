class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int min = 0;
        int minsum = 0;
        int maxsum = 0;

        for(int i=0;i<nums.length;i++){

            minsum += nums[i];
            maxsum += nums[i];
            max = Math.max(maxsum,max);
            min = Math.min(minsum,min);
            if(maxsum < 0){
                maxsum = 0;
            }
            if(minsum > 0){
                minsum = 0;
            }
        }
        
        return Math.max(max,Math.abs(min));
    }
}
