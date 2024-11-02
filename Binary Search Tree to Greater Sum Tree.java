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
    public TreeNode bstToGst(TreeNode root) {
        int sum = 0;
        convert(root,sum);
        return root;
    }
    public int convert(TreeNode root,int sum){
        if(root == null)return sum;

        int right = convert(root.right,sum);
        sum = right + root.val;
        root.val = sum;
        int left = convert(root.left,sum);
        
        return left;

    }
}

