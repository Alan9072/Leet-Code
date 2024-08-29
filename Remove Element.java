class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] == val && nums[right] != val){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
                
            }
            else if(nums[left] == val && nums[right] == val){
                right--;
            }
            else{
                left++;
            
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val)count++;
        }

        return count;
    }
}
