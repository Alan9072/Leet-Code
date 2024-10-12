class Solution {
    public double findMaxAverage(int[] nums, int k) {
        

        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }

        double maxAvg = (double) sum/k;

        int left = 0;
        int right = k;
        while(right < nums.length ){
            sum = sum - nums[left] + nums[right];
            left++;
            right++;
            
            double avg = (double) sum / k;
            if (avg > maxAvg) {
                maxAvg = avg;
            }
            
        }
        return maxAvg;

    }
}
