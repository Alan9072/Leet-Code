class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        HashMap<Integer, List<Integer>> posMap = new HashMap<>();
        HashMap<Integer, Integer> leftMap = new HashMap<>();
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            posMap.putIfAbsent(nums[i], new ArrayList<>());
            posMap.get(nums[i]).add(i);
        }

        for (int key : posMap.keySet()) {
            List<Integer> indices = posMap.get(key);
            int size = indices.size();
            
            if (size < 2) continue;

            for (int i = 0; i < size; i++) {
                int currentIndex = indices.get(i);
                int leftIndex = indices.get((i - 1 + size) % size);
                int rightIndex = indices.get((i + 1) % size); 

                leftMap.put(currentIndex, leftIndex);
                rightMap.put(currentIndex, rightIndex);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            if (!leftMap.containsKey(q) || !rightMap.containsKey(q)) {
                result.add(-1);
                continue;
            }

            int leftIdx = leftMap.get(q);
            int rightIdx = rightMap.get(q);

            int leftDist = Math.min(Math.abs(q - leftIdx), n - Math.abs(q - leftIdx));
            int rightDist = Math.min(Math.abs(q - rightIdx), n - Math.abs(q - rightIdx));

            result.add(Math.min(leftDist, rightDist));
        }

        return result;
    }
}
