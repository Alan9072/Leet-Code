class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] pair : nums1) {
            map.put(pair[0], pair[1]);
        }

        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        int[][] arr = new int[map.size()][2];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[index][0] = entry.getKey();
            arr[index][1] = entry.getValue();
            index++;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        return arr;
    }
}
