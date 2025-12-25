class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b - a;
        });
        for(int val : happiness){
            pq.add(val);
        }
        long sum = 0;
        int reduction = 0;

        int limit = 0;
        while(!pq.isEmpty() && limit < k){
            int curr = pq.poll() - reduction;
            if(curr <= 0)return sum;
            sum += curr;
            limit++;
            reduction++;
        }
        return sum;

    }
}
