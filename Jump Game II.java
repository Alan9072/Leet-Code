class Solution {
    public int jump(int[] nums) {
        int[] dummy = new int[nums.length];
        Arrays.fill(dummy, -1);
        return target(nums, 0, dummy);
    }

    public int target(int[] nums, int start, int[] dummy) {
        if (start >= nums.length - 1) {
            return 0;
        }

        if (dummy[start] != -1) return dummy[start];

        int possibleMin = Integer.MAX_VALUE;
        for (int i = start + 1; i <= (start + nums[start]) &&  i <= (nums.length - 1); i++) { 
            possibleMin = Math.min(target(nums, i, dummy), possibleMin);
        }

        dummy[start] = possibleMin == Integer.MAX_VALUE ? possibleMin : possibleMin + 1;
        return dummy[start];
    }
}
