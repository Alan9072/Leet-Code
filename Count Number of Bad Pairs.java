class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        long good = 0;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > 1) {
                good += (long) freq * (freq - 1) / 2;   // <-- Safe
            }
        }

        long totalPairs = (long) n * (n - 1) / 2;        // <-- Safe
        return totalPairs - good;
    }
}
