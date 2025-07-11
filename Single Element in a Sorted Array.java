class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            if(mid - 1 >= 0 && nums[mid - 1] == nums[mid]){
                if((mid - 1 - left) % 2 != 0){
                    right = mid - 2;
                }else{
                    left = mid + 1;
                }
                
            }else if(mid + 1 < nums.length && nums[mid + 1] == nums[mid] ){
                if((right - (mid + 1)) % 2 != 0){
                    left = mid + 2;
                }else{
                    right = mid - 1;
                }

            }else{
                return nums[mid];
            }
        }
        return nums[left];
    }
}
