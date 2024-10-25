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
    int mainSum = 0;
    public int findTilt(TreeNode root) {
   
        tilt(root);
        return mainSum;
    }
    public int tilt(TreeNode root){
        if(root == null)return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }

        int a = tilt(root.left);
        int b = tilt(root.right);

        mainSum += Math.abs(a - b);
        
        return root.val + a + b;
        
    }
}
