class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }
    
    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        
        max = Math.max(max, root.val + Math.max(0, left) + Math.max(0, right));
        return root.val + Math.max(0, Math.max(left, right));
    }
}
