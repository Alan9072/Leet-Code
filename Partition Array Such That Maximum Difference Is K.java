class Solution {
    public int partitionArray(int[] nums, int k) {
        int count = 1;
        Arrays.sort(nums);

        int start = nums[0];
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(curr - start > k){
                start = curr;
                count++;
                i--;
            }
        }
        return count;
    }
}
