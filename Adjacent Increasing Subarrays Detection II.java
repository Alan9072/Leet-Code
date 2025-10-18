class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int finalMax = 1;
        int max = 1;

        int len = 1;
        int prevLen = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                len++;
                if (len % 2 == 0) {
                    finalMax = Math.max(finalMax, len / 2);
                }
            } else {
                prevLen = len;
                len = 1;
            }
            max = Math.min(len, prevLen);
            finalMax = Math.max(max, finalMax);
        }
        return finalMax;
    }
}
