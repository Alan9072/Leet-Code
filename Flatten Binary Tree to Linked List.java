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
class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root == null)
            return root;

        if (root.left == null && root.right == null) {
            return root;
        }
        ///////////////////////////////////
        if (root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
            return flat(root.right);
        } else if (root.left == null && root.right != null) {
            root.left = null;
            root.right = root.right;
            return flat(root.right);
        } else {
            TreeNode rightNode = root.right;

            root.right = root.left;
            root.left = null;
            TreeNode node = flat(root.right);

            node.right = rightNode;
            return flat(rightNode);
        }

    }
}
