class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int val:stones){
            maxHeap.add(val);
        }
        while(maxHeap.size() > 1){
            int firstM = maxHeap.poll();
            if(firstM == maxHeap.peek()){
                maxHeap.poll();
            }else if(firstM > maxHeap.peek()){
                int val = firstM - maxHeap.poll();
                maxHeap.add(val);
            }
        }
        if(maxHeap.size() == 0)return 0;
        return maxHeap.peek();

    }
}
