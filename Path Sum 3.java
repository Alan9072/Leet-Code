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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> list = new ArrayList<>();

        sum(root,targetSum,list,0);
        return count;

    }
    public void sum(TreeNode root,int targetSum,List<Long> list,long adding){
        if(root == null)return;

        adding += root.val;
        list.add((long)root.val);

        long tempSum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            tempSum += list.get(i);
            if (tempSum == targetSum) {
                count++;
            }
        }
        sum(root.left,targetSum,list,adding);
        sum(root.right,targetSum,list,adding);

        list.remove(list.size() - 1);

        
    }
}
