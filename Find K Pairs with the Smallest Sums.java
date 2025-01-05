import java.util.*;

class Pair {
    int sum;
    int i;
    int j;

    Pair(int sum, int i, int j) {
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list; 
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        HashSet<String> visited = new HashSet<>();
        
        minHeap.add(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add(0 + "#" + 0);

        int count = 0;
        while (!minHeap.isEmpty() && count < k) {
            Pair curr = minHeap.poll();
            list.add(Arrays.asList(nums1[curr.i], nums2[curr.j]));
            count++;

            if (curr.i + 1 < nums1.length && !visited.contains((curr.i + 1) + "#" + curr.j)) {
                minHeap.add(new Pair(nums1[curr.i + 1] + nums2[curr.j], curr.i + 1, curr.j));
                visited.add((curr.i + 1) + "#" + curr.j);
            }

            if (curr.j + 1 < nums2.length && !visited.contains(curr.i + "#" + (curr.j + 1))) {
                minHeap.add(new Pair(nums1[curr.i] + nums2[curr.j + 1], curr.i, curr.j + 1));
                visited.add(curr.i + "#" + (curr.j + 1));
            }
        }

        return list;
    }
}
