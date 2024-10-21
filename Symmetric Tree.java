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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        if(root.left!= null && root.right== null){
            return false;
        }else if(root.right!= null && root.left== null){
            return false;
        }
        return isSym(root.left,root.right);
        
       

    }

    public boolean isSym(TreeNode rootleft,TreeNode rootright){
        if(rootleft == null && rootright == null){
            return true;
        }
        if(rootleft == null || rootright == null){
            return false;
        }
        if(rootleft.val != rootright.val){
            return false;
        }
          return   isSym(rootleft.left,rootright.right) && 
            isSym(rootleft.right,rootright.left);

    }
}
