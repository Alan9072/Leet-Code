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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null)return null;
        dfs(root.left,root.right,1);
        return root;
    }
    public void dfs(TreeNode left,TreeNode right,int val){
        if(left == null || right == null)return;

        if(val % 2 == 1){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        dfs(left.left,right.right,val+1);
        dfs(left.right,right.left,val+1);
    }
}
