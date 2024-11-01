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
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }

        insert(root,val);
        return root;

    }
    public void insert(TreeNode root, int val){

        
    
        if(val < root.val){
            if(root.left != null){
                insertIntoBST(root.left,val);
            }
            else{
                TreeNode newNode = new TreeNode(val);
                root.left = newNode;
            }
            
        }
        else{
            if(root.right != null){
                insertIntoBST(root.right,val);
            }
            else{
                TreeNode newNode = new TreeNode(val);
                root.right = newNode;
            }
        }
    }
}
