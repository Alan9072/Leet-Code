class Pair{
    int node;
    double prob;
    Pair(int node,double prob){
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] pro = new double[n];

        Arrays.fill(pro,Double.MIN_VALUE);

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));

        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b)->{
            return Double.compare(b.prob,a.prob);
        });

        maxHeap.add(new Pair(start_node,1));
        pro[start_node] = 1;

        while(!maxHeap.isEmpty()){
            Pair curr = maxHeap.poll();
            int node = curr.node;
            double prob = curr.prob;

            List<Pair> sub = graph.get(curr.node);

            for(int i=0;i<sub.size();i++){
                Pair currN = sub.get(i);

                if(prob * currN.prob > pro[currN.node]){
                    double newProb = prob * currN.prob;
                    pro[currN.node] = newProb;
                    maxHeap.add(new Pair(currN.node,newProb));
                }
            }


        }

        return pro[end_node] == Double.MIN_VALUE ? 0 : pro[end_node];


    }
}
