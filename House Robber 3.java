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
    public int rob(TreeNode root) {
        HashMap<TreeNode,int[]> map = new HashMap<>();
        return dfs(root,0,map);
    }
    public int dfs(TreeNode root,int choice,HashMap<TreeNode,int[]> map){
        if(root == null)return 0;
        if(map.containsKey(root)){
            if(map.get(root)[choice] != -1)return map.get(root)[choice];
        }

        int taken = 0;
        if(choice == 0){
            taken = root.val + dfs(root.left,1,map) + dfs(root.right,1,map);
        } 
        int notTaken = dfs(root.left,0,map) + dfs(root.right,0,map);

        map.put(root,new int[]{-1,-1});
        map.get(root)[choice] = Math.max(taken,notTaken);

        return map.get(root)[choice];
    }
}
