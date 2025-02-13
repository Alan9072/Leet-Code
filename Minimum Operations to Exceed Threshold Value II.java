class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int operations = 0;
        for(long val : nums){
            minHeap.add(val);
        }

        if (minHeap.peek() >= k) return 0;

        while(minHeap.size() >= 2){

            long first = minHeap.poll();
            if(first >= k)return operations;
            long second = minHeap.poll();

            minHeap.add(first * 2 + second);
            operations++;
        }
        
        return operations;
    }
}
