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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> mainlist = new ArrayList<>();
        // if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){

            if(q.size() == 1 && q.remove() == null )break;

            List<Integer> sub = new ArrayList<>();
            TreeNode curr = q.remove();
            

            while(curr!=null){
                sub.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                curr = q.remove();
            }

            q.add(null);
            mainlist.add(sub); 
        }
        return mainlist.get(mainlist.size() - 1).get(0);

    }
}
