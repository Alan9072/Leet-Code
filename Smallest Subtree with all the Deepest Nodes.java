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
    TreeNode root;
    int depth;
    Pair(TreeNode root,int depth){
        this.root = root;
        this.depth = depth;
    }
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair result = dfs(root,0);
        return result.root;
    }
    public Pair dfs(TreeNode root,int depth){
        if(root == null)return null;

        Pair left = dfs(root.left,depth + 1);
        Pair right = dfs(root.right,depth + 1);

        if(left == null && right == null){
            return new Pair(root,depth);
        }else if(left != null && right != null){
            if(left.depth == right.depth){
                return new Pair(root,left.depth);
            }else if(left.depth > right.depth){
                return left;
            }else{
                return right;
            }
        }else if(right == null){
            return left;
        }else{
            return right;
        }
    }
}
