

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> List = new ArrayList<>(nums.length + 1);
        for (int i = 0; i <= nums.length; i++) {
            List.add(new ArrayList<>());
        }

        for (Integer val : map.keySet()) {
            int frequency = map.get(val);
            List<Integer> curr = List.get(frequency);
            curr.add(val);
            List.set(frequency, curr);
        }

        List<Integer> result = new ArrayList<>();
        
        for (int i = List.size() - 1; i >= 0; i--) {
            if (result.size() >= k) {
                break;
            }

            for (Integer num : List.get(i)) {
                result.add(num);
                if (result.size() == k) {
                    break;
                }
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
