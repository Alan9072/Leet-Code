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
class Pair{
    TreeNode root;
    int depth;
    Pair(TreeNode root,int depth){
        this.root = root;
        this.depth = depth;
    }
}
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair curr = new Pair(root,0);
        Pair current = deepest(curr);
        return current.root;
    }
    public Pair deepest(Pair curr){
        if(curr.root == null)return new Pair(null,curr.depth);

        Pair left = new Pair(curr.root.left,curr.depth + 1);
        Pair right = new Pair(curr.root.right,curr.depth + 1);

        Pair LeftR = deepest(left);
        Pair rightR = deepest(right);

        if(LeftR.depth > rightR.depth)return LeftR;
        else if(rightR.depth > LeftR.depth)return rightR;
        else{
            int depthh = LeftR.depth;
            return new Pair(curr.root,depthh); 
        }



    }
}
