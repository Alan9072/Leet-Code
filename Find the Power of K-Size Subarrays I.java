class Solution {

    public int[] resultsArray(int[] nums, int k) {
        int result[] = new int[nums.length - k + 1];
        int pos = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int flag = 0;
            int max = nums[i];

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    flag = 1;
                    break;
                } else {
                    max = Math.max(nums[j + 1], max);
                }
            }
            if (flag == 0) {
                result[pos] = max;
            } else {
                result[pos] = -1;
            }
            pos++;
        }
        return result;
    }
}
