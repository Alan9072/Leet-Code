class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int freq = 0;
        int max = 0;
        for (int key : map.keySet()) {

            int val = map.get(key);
            if (val > max) {
                max = val;
                freq = val;
            } else if (val == max) {
                freq += val;
            }

        }

        return freq;
    }
}
