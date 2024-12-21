class Solution {
    int count = 1;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int[] visited = new int[n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int arr[] = edges[i];
            tree.get(arr[0]).add(arr[1]);
            tree.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
               dfs(i, visited, values, k, tree);
            //    if(val % k == 0)count++; just comments
            }
        }
        return count;
    }

    public long dfs(int curr, int[] visited, int[] values, int k, List<List<Integer>> tree) {
        if (visited[curr] == 1) {
            return -1;
        }
        visited[curr] = 1;
        long sum = 0;
        for (int i = 0; i < tree.get(curr).size(); i++) {
            long val = dfs(tree.get(curr).get(i), visited, values, k, tree);
            if (val != -1) {
                if (val % k == 0) {
                    count++;
                } else {
                    sum += val;
                }
            }
        }

        return sum + values[curr];
    }

}
