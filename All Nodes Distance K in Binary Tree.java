/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    int val;
    int dist;
    Pair(int val,int dist){
        this.val = val;
        this.dist = dist;
    }
}
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] visited = new int[501];
        for(int i=1;i<=500;i++){
            graph.add(new ArrayList<>());
        }
        dfs(root,graph);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target.val,0));

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int val = curr.val;
            int dist = curr.dist;

            visited[val] = 1;

            if(dist == k){
                result.add(val);
                continue;
            }

            List<Integer> edges = graph.get(val);
            for(int i=0;i<edges.size();i++){

                int edge = edges.get(i);
                if(visited[edge] == 0){
                    q.add(new Pair(edge,dist + 1));
                }
                
            }

        }
        return result;
    }
    public void dfs(TreeNode root,List<List<Integer>> graph){

        int rootVal = root.val;

        if(root.left != null){
            int leftVal = root.left.val;
            graph.get(rootVal).add(leftVal);
            graph.get(leftVal).add(rootVal);
            dfs(root.left,graph);
        }

        if(root.right != null){
            int rightVal = root.right.val;
            graph.get(rootVal).add(rightVal);
            graph.get(rightVal).add(rootVal);
            dfs(root.right,graph);
        }

        return;
    }
}
