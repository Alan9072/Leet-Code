class Solution {
    List<List<Integer>> mainList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        calculatePath(0,graph,new ArrayList<>());
        return mainList;
    }
    public void calculatePath(int start,int[][] graph,List<Integer> subList){
        if(start == graph.length - 1){
            subList.add(start);
            mainList.add(new ArrayList<>(subList));
            subList.remove(subList.size() - 1);
            return;
        }
        for(int i=0;i<graph[start].length;i++){
            subList.add(start);
            calculatePath(graph[start][i],graph,subList);
            subList.remove(subList.size() - 1);
        }
    }
}
