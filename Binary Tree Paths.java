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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        StringBuilder string = new StringBuilder("");
        search(root,string);
        return list;
    }
    public void search(TreeNode root,StringBuilder word){
        
        if(root == null)return;
        
        int curr = word.length();
        word.append(root.val);
        
        if(root.left == null && root.right == null){
            // word.append(root.val);
            list.add(word.toString());
           
        }
        else{
            word.append("->");
            search(root.left,word);
            search(root.right,word);
        }
        // word.append(root.val);
       

        word.setLength(curr);
        return ;

    }
}
