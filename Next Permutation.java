class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;

        int i = -1;
        for(i=length - 2;i>=0;i--){
            if(nums[i] < nums[i + 1]){
                int index = -1;
                int minSum = Integer.MAX_VALUE;
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j] > nums[i] && nums[j] - nums[i] < minSum ){
                        index = j;
                    }
                }
                int curr = nums[i];
                nums[i] = nums[index];
                nums[index] = curr;
                break;
            }
        }
        for(int j = i+1;j<nums.length;j++){
            for(int k = j+1;k<nums.length;k++){
                if(nums[k] < nums[j]){
                    int temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }
}
