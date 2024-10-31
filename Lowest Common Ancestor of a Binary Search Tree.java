/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ancestor(root,p,q);
    }
    public TreeNode ancestor(TreeNode root,TreeNode p,TreeNode q){
       if(root == null)return null;
       if(root == p || root == q)return root;

       TreeNode left = ancestor(root.left,p,q);
       TreeNode right = ancestor(root.right,p,q);

       if(left != null && right == null){
            return left;
       }
       else if(right != null && left == null){
            return right;
       }else if(left != null && right != null){
            return root;
       }else{
            return null;
       }
       
    }
}
