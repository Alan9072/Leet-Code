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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> sub = new ArrayList<>(); 
        if(root == null)return sub;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            TreeNode curr = q.remove();
            if(curr == null && q.isEmpty())break;
            
            while(curr != null){
 
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                TreeNode prev = curr;
                curr = q.remove();
                if(prev!=null && curr == null){
                    sub.add(prev.val);
                }
            }
            q.add(null);
        }
  
        return sub;
    }
}
