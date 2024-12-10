/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return node;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);

        if (left && right) {
            node = root;
        } else if (left == true && (root == p || root == q))
            node = root;
        else if (right == true && (root == p || root == q))
            node = root;

        if (root == p || root == q)
            return true;

        return left || right;
    }
}
