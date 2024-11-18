class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int limit =(int) Math.floor(nums.length / 3);
        for (int key : map.keySet()) {
            if (map.get(key) > limit) {
                result.add(key);
            }
        }
        return result;
    }
}
