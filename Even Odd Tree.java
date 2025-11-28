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
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        dfs(root,0,map);
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            if(key % 2 == 0){
                int prev = -1;
                for(int val : list){
                    if(val % 2 == 0)return false;
                    if(val <= prev)return false;
                    prev = val;
                }
            }else{
                int prev = Integer.MAX_VALUE;
                for(int val : list){
                    if(val % 2 != 0)return false;
                    if(val >= prev)return false;
                    prev = val;
                }
            }
        }
        return true;
    }
    public void dfs(TreeNode root,int lvl,HashMap<Integer,List<Integer>> map){
        if(root == null)return;

        map.putIfAbsent(lvl,new ArrayList<>());
        map.get(lvl).add(root.val);

        dfs(root.left,lvl+1,map);
        dfs(root.right,lvl+1,map);

    }
}
