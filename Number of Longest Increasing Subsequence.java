class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[][] len = new int[n + 1][n];
        for (int[] arr : len) {
            Arrays.fill(arr, -1);
        }
        int maxLen = findMax(-1, 0, nums, len);

        int[][] count = new int[n + 1][n];
        for (int[] arr : count) {
            Arrays.fill(arr, -1);
        }
        return findCount(-1, 0, nums, len, count, maxLen);
    }

    public int findMax(int prev, int idx, int[] nums, int[][] len) {
        if (idx == nums.length)
            return 0;
        if (len[idx][prev + 1] != -1)
            return len[idx][prev + 1];

        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + findMax(idx, idx + 1, nums, len);
        }
        int notTake = findMax(prev, idx + 1, nums, len);

        return len[idx][prev + 1] = Math.max(take, notTake);
    }

    public int findCount(int prev, int idx, int[] nums, int[][] len, int[][] count, int remainingLen) {
        if (remainingLen == 0) return 1;
        if (idx == nums.length) return 0;
        if (count[idx][prev + 1] != -1) return count[idx][prev + 1];

        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            if (1 + findMax(idx, idx + 1, nums, len) == remainingLen) {
                take = findCount(idx, idx + 1, nums, len, count, remainingLen - 1);
            }
        }

        int notTake = findCount(prev, idx + 1, nums, len, count, remainingLen);

        return count[idx][prev + 1] = take + notTake;
    }

}
