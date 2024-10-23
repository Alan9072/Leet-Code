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
    int sumLeaf = 0;
    public int sumNumbers(TreeNode root) {
        StringBuilder string = new StringBuilder();
        sum(root,string);
        return sumLeaf;

    }
    public void sum(TreeNode root,StringBuilder string){
        if(root == null)return ;

        string.append(root.val);
        int length = string.length();
        if(root.left == null && root.right == null){

            sumLeaf += Integer.parseInt(string.toString());
        }
        else{
            
            sum(root.left,string);
            sum(root.right,string);
        }

       

        string.setLength(length - 1);
    }
}
