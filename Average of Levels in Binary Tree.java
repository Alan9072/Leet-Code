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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        double sum = 0;
        double count = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null)break;
            
            while(curr != null){
                sum += curr.val;
                count++;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }

                curr = q.poll();
            }
            list.add(sum / count);
            sum = 0;
            count = 0;

            q.add(null);
        }
        return list;
    }
}
