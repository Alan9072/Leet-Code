class Solution {
    public boolean predictTheWinner(int[] nums) {
        return dfs(0, nums.length - 1, nums, 0, 0, 0);
    }

    boolean dfs(int i, int j, int[] nums, int turn, int p1, int p2) {
        if (i > j) return p1 >= p2;

        if (turn == 0) { // P1's turn
            boolean left = dfs(i + 1, j, nums, 1, p1 + nums[i], p2);
            boolean right = dfs(i, j - 1, nums, 1, p1 + nums[j], p2);
            return left || right;
        } else { // P2's turn
            boolean left = dfs(i + 1, j, nums, 0, p1, p2 + nums[i]);
            boolean right = dfs(i, j - 1, nums, 0, p1, p2 + nums[j]);
            return left && right;
        }
    }
}
