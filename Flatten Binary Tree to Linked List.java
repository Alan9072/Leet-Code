class Solution {
    public void flatten(TreeNode root) {
        flat(root);
    }

    public TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = flat(root.left);
        TreeNode rightTail = flat(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightTail != null) {
            return rightTail;
        } else if (leftTail != null) {
            return leftTail;
        } else {
            return root;
        }
    }
}
