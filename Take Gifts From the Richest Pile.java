class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < gifts.length; i++) {
            maxHeap.add(gifts[i]);
        }
        int time = 0;
        while(time < k){
            
            maxHeap.add((int)Math.floor(Math.sqrt(maxHeap.poll())));
            time++;
        }
        long sum = 0;
        while(!maxHeap.isEmpty()){
            sum += maxHeap.poll();
        }
        return sum;

    }
}
