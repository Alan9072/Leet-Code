class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        int start = 0;
        while(start != fast){
            start = nums[start];
            fast = nums[fast];
        }
        return fast;
    }
}
