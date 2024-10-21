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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();

        if(root == null)return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int zigzag = 0;
        while(!q.isEmpty()){
                if(q.size() == 1 && q.remove() == null)break;
                List<Integer> sublist = new ArrayList<>();
                TreeNode curr = q.remove();
                while(curr != null){
                    sublist.add(curr.val);
                    if(curr.left!=null){
                        q.add(curr.left);
                        }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                    curr = q.remove();
                }
                q.add(null);
                if(zigzag%2 == 0){
                    
                    list.add(sublist);
                }
                else{
                    Collections.reverse(sublist);
                    list.add(sublist);

                }
                zigzag++;
                
            }
    
        return list;
    }
    
}

