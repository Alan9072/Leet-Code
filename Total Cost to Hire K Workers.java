import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();
        long cost = 0;

        int left = 0;
        int right = costs.length - 1;

        for (left = 0; left < candidates && left <= right; left++) {
            minHeap1.add(costs[left]);
        }

        for (right = costs.length - 1; right >= costs.length - candidates && right >= left; right--) {
            minHeap2.add(costs[right]);
        }

        int sessions = 0;
        while (sessions < k) {
            int val1 = minHeap1.isEmpty() ? Integer.MAX_VALUE : minHeap1.peek();
            int val2 = minHeap2.isEmpty() ? Integer.MAX_VALUE : minHeap2.peek();

            if (val1 <= val2) {
                cost += val1;
                minHeap1.poll();
                if (left <= right) {
                    minHeap1.add(costs[left]);
                    left++;
                }
            } else {
                cost += val2;
                minHeap2.poll();
                if (right >= left) {
                    minHeap2.add(costs[right]);
                    right--;
                }
            }
            sessions++;
        }

        return cost;
    }
}
