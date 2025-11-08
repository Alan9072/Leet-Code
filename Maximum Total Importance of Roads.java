class Pair{
    int idx;
    long size;
    Pair(int idx,long size){
        this.idx = idx;
        this.size = size;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long degree[] = new long[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return (int)(b.size - a.size);
        });
        for(int i=0;i<roads.length;i++){
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        for(int i=0;i<n;i++){
            pq.add(new Pair(i,degree[i]));
        }
        int val = n;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            degree[curr.idx] = val;
            val--;
        }
        long sum = 0;
        for(int[] edge : roads){
            sum += degree[edge[0]] + degree[edge[1]];
        }
        return sum;
    }
}
