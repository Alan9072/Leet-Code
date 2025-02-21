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
class FindElements {
    HashSet<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(root.val);
        recover(root.left,0,1);
        recover(root.right,0,2);
    }
    public void recover(TreeNode root,int parent,int add){
        if(root == null){
            return;
        }
        root.val = 2 * parent + add;
        set.add(root.val);
        recover(root.left,root.val,1);
        recover(root.right,root.val,2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
