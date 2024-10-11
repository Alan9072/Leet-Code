class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                int start = mid;
                int end = mid;
                
                while (start - 1 >= 0 && nums[start - 1] == target) {
                    start--;
                }
                
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                
                return new int[]{start, end};
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
