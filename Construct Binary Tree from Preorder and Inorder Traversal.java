/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
import java.util.Arrays;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder);
    }

    public TreeNode build(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        int currVal = preorder[0];
        TreeNode node = new TreeNode(currVal);

    
        int mid = 0;
        while (inorder[mid] != currVal) {
            mid++;
        }


        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        int[] rightIn = Arrays.copyOfRange(inorder, mid + 1, inorder.length);


        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

 
        node.left = build(leftPre, leftIn);
        node.right = build(rightPre, rightIn);

        return node;
    }
}
