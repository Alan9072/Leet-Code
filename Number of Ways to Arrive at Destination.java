class Pair{
    int node;
    long time;
    Pair(int node,long time){
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1000000007;
        long[] time = new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        time[0] = 0;

        int[] count = new int[n];
        count[0] = 1;


        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads){
            graph.get(road[0]).add(new Pair(road[1],road[2]));
            graph.get(road[1]).add(new Pair(road[0],road[2]));
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->{
            return Long.compare(a.time, b.time);
        });

        minHeap.add(new Pair(0,0));

        while(!minHeap.isEmpty()){
            Pair curr = minHeap.poll();
            int node = curr.node;
            long timeV = curr.time;

            // if (timeV > time[node]) continue;

            List<Pair> cRoads = graph.get(node);

            for(int i=0;i<cRoads.size();i++){
                Pair curP = cRoads.get(i);
                int currN = curP.node;
                long currT = curP.time;

                if(timeV + currT < time[currN]){
                    long newT = timeV + currT;
                    time[currN] = newT;
                    minHeap.add(new Pair(currN,newT));
                    count[currN] = count[node];
                }else if(timeV + currT == time[currN]){
                    count[currN] = (count[currN] + count[node]) % MOD;
                }
            }

        }
        return count[n - 1];

    }
}
