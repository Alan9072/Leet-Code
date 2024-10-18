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
    // int height = 0;
    // int currHeight = 0;
    public int maxDepth(TreeNode root){ 
        // height(root);
        // return height;
        if(root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }
    // public void height(TreeNode root){
    //     if(root == null){
    //         return ;
    //     }
        
    //     else{
    //         currHeight++;
    //     }
    //     maxDepth(root.left);
    //     maxDepth(root.right);
    //     if(currHeight > height){
    //         height = currHeight;
    //     }
    //     currHeight--;
    //     return ;
    // }
}
