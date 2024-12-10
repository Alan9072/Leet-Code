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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null; // Case: Leaf node, return null to delete it
            }
            if (root.left != null) {
                TreeNode right = root.right;
                TreeNode left = root.left;
                TreeNode ptr = left;

                while (ptr.right != null) {
                    ptr = ptr.right;
                }
                ptr.right = right;
                return left;
            }
            if (root.right != null) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                TreeNode ptr = right;

                while (ptr.left != null) {
                    ptr = ptr.left;
                }
                ptr.left = left;
                return right;
            }
        }else if(key < root.val){
            root.left = delete(root.left,key);
        }else{
            root.right = delete(root.right,key);
        }
        // root.left = delete(root.left, key);
        // root.right = delete(root.right, key);

        return root;
    }
}
