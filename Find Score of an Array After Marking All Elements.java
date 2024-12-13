class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new int[] { nums[i], i });
        }
        while (visited.size() != nums.length) {
            int arr[] = minHeap.poll();
            if (!visited.contains(arr[1])) {
                score += arr[0];
                visited.add(arr[1]);
                if (!visited.contains(arr[1] - 1) && arr[1] - 1 >= 0) {
                    visited.add(arr[1] - 1);
                }
                if (!visited.contains(arr[1] + 1) && arr[1] + 1 < nums.length) {
                    visited.add(arr[1] + 1);
                }
            }

        }
        return score;
    }
}
