class Pair{
    int des;
    int distance;
    Pair(int des,int distance){
        this.des = des;
        this.distance = distance;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /// for checking the minimum value from node k
        int[] distance = new int[n+1];
        for(int i=0;i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        //Making a graph with weights mentioned//////
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int arr[] = times[i];
            graph.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }
        /////////////////////////////////////////////////

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)-> {
            if(a.distance == b.distance) return a.des - b.des;//special condition
            return a.distance - b.distance;// ''''''''''
        });

        //since in question they are not including 0 so set the below conditions
        minHeap.add(new Pair(k,0));
        distance[k] = 0;
        distance[0] = 0;
        ////////////////////////////////////////////////////////////////////

        while(!minHeap.isEmpty()){
            Pair curr = minHeap.poll();        // ex : remove (2,0)
            int currDistance = curr.distance; // currDistance = 0
            for(int i=0;i<graph.get(curr.des).size();i++){ // checking all the neighbours 
                Pair next = graph.get(curr.des).get(i);  // taking the i th neighbour | ex :  take (1,1)
                int destination = next.des; // here destination = 1 of (1,1)
                if(distance[destination] > currDistance + next.distance){ // check if this is more shorter
                    // like here currDistance = 0 + next.distacne = 1 < Integer.max 
                    int newDistance = currDistance + next.distance;
                    distance[destination] = newDistance;      
                    minHeap.add(new Pair(destination,newDistance)); // add the new pair into heap (1,1)
                }
            }
        }
        int min = 0;
        for(int val : distance){
            if(val == Integer.MAX_VALUE)return -1;
            min = Math.max(min,val);
        }
        return min;

    }
}
