class Solution {
    public void rotate(int[] nums, int k) {
        int pos = k % nums.length;
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }

        for(int i=0;i<nums.length;i++){
            nums[pos] = arr[i];
            pos = (pos + 1) % nums.length;
        }
        
    }
}
