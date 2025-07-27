class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new HashSet<>());
        }

        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int max = 0;
        for(int i=0;i<n - 1;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> first = graph.get(i);
                Set<Integer> second = graph.get(j);

                int sum = first.size() + second.size();

                if(second.contains(i)){
                    sum -= 1;
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
