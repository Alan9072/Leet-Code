class Solution {
    int count = 0;
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i == j)continue;

                if(check(i,j,nums)){
                    graph.get(i).add(j);
                }
            }
        }

        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            visited[i] = 1;
            dfs(i, 1, nums, visited, graph);
            visited[i] = 0;
        }

        return count;

    }
    private void dfs(int curr, int depth, int[] nums, int[] visited, List<List<Integer>> graph) {
        if (depth == nums.length) {
            count++;
            return;
        }

        for (int nei : graph.get(curr)) {
            if (visited[nei] == 1) continue;

            // skip duplicates unless the previous identical value was used
            if (nei > 0 && nums[nei] == nums[nei - 1] && visited[nei - 1] == 0) continue;

            visited[nei] = 1;
            dfs(nei, depth + 1, nums, visited, graph);
            visited[nei] = 0;
        }
    }

    public boolean check(int i,int j,int[] nums){

        int root = (int) Math.sqrt(nums[i] + nums[j]);

        return root * root == nums[i] + nums[j];
    }
}
