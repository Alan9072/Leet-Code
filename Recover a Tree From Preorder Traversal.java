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
    public TreeNode recoverFromPreorder(String traversal) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // extract root value (may be multiple digits)
        while (i < traversal.length() && traversal.charAt(i) != '-') {
            sb.append(traversal.charAt(i));
            i++;
        }
        int rootVal = Integer.parseInt(sb.toString());
        TreeNode node = new TreeNode(rootVal);
        dfs(node, 0, traversal.substring(i));
        return node;
    }

    public String dfs(TreeNode root, int val, String traversal) {
        if (traversal.isEmpty()) return "";

        int dash = 0;
        int index = 0;
        while (index < traversal.length() && traversal.charAt(index) == '-') {
            dash++;
            index++;
        }

        String num = "";
        while (index < traversal.length() && traversal.charAt(index) != '-') {
            num += traversal.charAt(index);
            index++;
        }

        if (num.isEmpty()) return traversal; // no more nodes

        int value = Integer.parseInt(num);
        if (dash - val == 1) {
            TreeNode leftNode = new TreeNode(value);
            root.left = leftNode;
            String rem = dfs(leftNode, dash, traversal.substring(index));

            if (rem.isEmpty()) return "";

            // Now try to parse the right child
            dash = 0;
            index = 0;
            while (index < rem.length() && rem.charAt(index) == '-') {
                dash++;
                index++;
            }

            num = "";
            while (index < rem.length() && rem.charAt(index) != '-') {
                num += rem.charAt(index);
                index++;
            }

            if (!num.isEmpty() && dash - val == 1) {
                int rightVal = Integer.parseInt(num);
                TreeNode rightNode = new TreeNode(rightVal);
                root.right = rightNode;
                return dfs(rightNode, dash, rem.substring(index));
            } else {
                root.right = null;
                return rem; // return remaining string as is
            }
        } else {
            // Not the expected depth, backtrack
            return traversal;
        }
    }
}
