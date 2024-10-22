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
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> sublist = new ArrayList<>();
        int sum = 0;
        Sum(root,targetSum,sublist,sum);
        return list;
    }
    public void Sum(TreeNode root, int targetSum,List<Integer> sublist,int sum){
        if(root == null)return;

        sublist.add(root.val);
        sum+=root.val;

        if(root.left == null && root.right == null && sum == targetSum){
            list.add(new ArrayList<>(sublist));
        }
        else{
            
            Sum(root.left,targetSum,sublist,sum);
            Sum(root.right,targetSum,sublist,sum);
        }
        sublist.remove(sublist.size() - 1);
    }
}
