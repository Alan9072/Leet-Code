class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length) {
            int curr = nums[right];
            int count = 0;
            while (right < nums.length && nums[right] == curr) {
                count++;

                if (count <= 2) {
                    result++;
                    nums[left] = nums[right];
                    left++;

                }

                right++;
            }

        }
        return result;
    }
}
