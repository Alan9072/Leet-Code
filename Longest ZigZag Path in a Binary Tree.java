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
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        zigzag(root.left,"L",1);
        zigzag(root.right,"R",1);
        return maxLen;
    }
    public void zigzag(TreeNode root,String direction,int value){
        if(root == null){
            return;
        }

        maxLen = Math.max(maxLen,value);

        if(direction.equals("L")){
            zigzag(root.left,"L",1);
            zigzag(root.right,"R",value + 1);
        }else{
            zigzag(root.left,"L",value + 1);
            zigzag(root.right,"R",1);
        }
        
    }
}
