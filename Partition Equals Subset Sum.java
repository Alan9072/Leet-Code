class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0)
            return false;

        int mainTotal = total / 2;
        int[][] dp = new int[nums.length][mainTotal + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return find(nums, 0, 0, mainTotal, dp);
    }

    public boolean find(int[] nums, int index, int currentSum, int mainTotal, int[][] dp) {
        if (currentSum == mainTotal) {
            return true;
        }

        if (currentSum > mainTotal || index == nums.length)
            return false;

        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum] == 1;
        }

        boolean include = find(nums, index + 1, currentSum + nums[index], mainTotal, dp);
        boolean exclude = find(nums, index + 1, currentSum, mainTotal, dp);

        dp[index][currentSum] = (include || exclude) ? 1 : 0;
        return dp[index][currentSum] == 1;
    }
}
