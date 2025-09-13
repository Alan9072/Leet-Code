
class Solution {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max - 1; 
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftPth = dfs(root.left);
        int rightPth = dfs(root.right);

        if(leftPth == 0 && rightPth == 0){
            max = Math.max(max,1);
            return 1;
        }

        int left = 1;
        int right = 1;
        if(root.left != null && root.left.val == root.val && root.right != null && root.right.val == root.val){
            max = Math.max(max,leftPth + rightPth + 1);
        }
        if(root.left != null && root.left.val == root.val){
            left = leftPth + 1;
            max = Math.max(max,left);
        }
        if(root.right != null && root.right.val == root.val){
            right = rightPth + 1;
            max = Math.max(max,right);
        }

        return Math.max(left,right);

    }
}
