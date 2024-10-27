class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0]+ nums[1]+ nums[2];

        Arrays.sort(nums);
        for(int i=0;i<nums.length - 2;i++){
            int curr = nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int subSum = curr + nums[left] + nums[right];
                
                if(Math.abs(target - subSum) <= Math.abs(target - sum)){
                    sum = subSum;
                }
                if(subSum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return sum;
    }
}
