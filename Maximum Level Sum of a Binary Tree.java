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
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        int mainSum = Integer.MIN_VALUE;
        int largest = 1;

        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {

            if (q.size() == 1 && q.remove() == null)
                break;
            int sum = 0;
            TreeNode curr = q.remove();

            while (curr != null) {
                sum += curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                curr = q.remove();
            }
            if (sum > mainSum) {
                largest = level;
                mainSum = sum;
            }
            level++;
            q.add(null);

        }

        return largest;

    }
}
