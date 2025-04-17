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
    int sum;
    public int deepestLeavesSum(TreeNode root) {
        int depth = dfs(root);
        dfsSum(root,depth,0);
        return sum;
    }
    public int dfs(TreeNode root){
        if(root == null)return -1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left,right) + 1;
    }
    public void dfsSum(TreeNode root,int depth,int level){
        if(root == null)return;

        if(level == depth){
            sum += root.val;
            return;
        }

        dfsSum(root.left,depth,level + 1);
        dfsSum(root.right,depth,level + 1);
    }
}
