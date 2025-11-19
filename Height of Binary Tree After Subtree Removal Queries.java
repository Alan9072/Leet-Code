/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    int contri;
    int lvl;
    Pair(int contri,int lvl){
        this.contri = contri;
        this.lvl = lvl;
    }
}
class Solution {
    HashMap<Integer,List<Integer>> lvl = new HashMap<>();
    HashMap<Integer,Pair> val = new HashMap<>();
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfs(root,1);

        int[] result = new int[queries.length];
        int height = lvl.size() - 1;

        for(int key : lvl.keySet()){
            List<Integer> list = lvl.get(key);
            Collections.sort(list);
        }

        for(int i=0;i<queries.length;i++){
            int query = queries[i];
            Pair curr = val.get(query);

            List<Integer> list = lvl.get(curr.lvl);
            int lsize = list.size() - 1;
            if(list.get(lsize) == curr.contri){
                if(lsize - 1 >= 0){
                    if(list.get(lsize) == list.get(lsize - 1)){
                        result[i] = height;
                    }else{
                        result[i] = height - list.get(lsize) + list.get(lsize - 1);
                    }
                }else{
                    result[i] = height - list.get(lsize);
                }
            }else{
                result[i] = height;
            }
        }

        return result;
    }
    public int dfs(TreeNode root,int currLvl){
        if(root == null)return 0;

        int left = dfs(root.left,currLvl + 1);
        int right = dfs(root.right,currLvl + 1);

        int max = 1 + Math.max(left,right);

        lvl.putIfAbsent(currLvl,new ArrayList<>());
        lvl.get(currLvl).add(max);

        Pair curr = new Pair(max,currLvl);
        val.put(root.val,curr);

        return max;
    }
}
