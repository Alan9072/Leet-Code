class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int[] values = new int[2001];
        int[] dummy = new int[2001];
        for(int val : nums){
            values[val]++;
        }

        int countDis = 0;
        for(int val : values){
            if(val > 0)countDis++;
        }

        int subArrayCount = 0;
        int subCount = 0;

        int left = 0;
        for(int right = 0;right < nums.length;right++){
            int val = nums[right];
            dummy[val]++;

            if(dummy[val] == 1){
                subCount++;
            }

            while(subCount >= countDis){
                subArrayCount += nums.length - right;

                int currVal = nums[left];
                dummy[currVal]--;
                if(dummy[currVal] == 0){
                    subCount--;
                }
                left++;
            }
        }
        return subArrayCount;
    }
}
