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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> a = check(root1,new ArrayList<>());
        List<Integer> b = check(root2,new ArrayList<>());

        return a.equals(b);
    }
    public List<Integer> check(TreeNode root,List<Integer> list){
        if(root == null)return null;

        if(root.left == null && root.right == null){
            list.add(root.val);
            return list;
        }

        check(root.left,list);
        check(root.right,list);

        return list;
        
    }
}
