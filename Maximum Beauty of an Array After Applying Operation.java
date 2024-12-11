class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int length = 0;

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;
    }
}
