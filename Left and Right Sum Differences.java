class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum[] = new int[nums.length];
        int rightSum[] = new int[nums.length];
        int answer[] = new int[nums.length];
        int sum = 0;
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    leftSum[i] = 0;
                }
                else{
                    leftSum[i] = sum;
                }
                  sum = sum + nums[i];
        }

         for (int i = 0; i < nums.length; i++) {
                if(i == nums.length - 1){
                    rightSum[i] = 0;    
                }
                else{
                    rightSum[i] = totalSum  - nums[i];
                    totalSum = totalSum  - nums[i];
                }   
        }

         for (int i = 0; i < nums.length; i++) {
                answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return answer;
    }
}
