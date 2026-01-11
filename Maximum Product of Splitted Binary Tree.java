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
    int MOD = 1000000000 + 7;
    long result = 0;
    public int maxProduct(TreeNode root) {
        int sum = dfs(root);
        find(root,sum);
        return (int)(result % MOD);
    }
    public int dfs(TreeNode root){
        if(root == null)return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return left + right + root.val;
    }
    public int find(TreeNode root,int sum){
        if(root == null)return 0;

        int left = find(root.left,sum);
        int right = find(root.right,sum);

        long leftRmSum = ( sum - left ) * (long) left;
        long rightRmSum = ( sum - right ) * (long) right;
        result = Math.max(result,Math.max(leftRmSum,rightRmSum));

        return left + right + root.val;
    }
}
