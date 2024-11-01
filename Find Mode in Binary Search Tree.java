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
    HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        find(root);
        int greatest = 0;
        int count = 0;
        for(int val : map.values()){
            if(val > greatest){
                greatest = val;
                count = 1;
            }
            else if(val == greatest){
                count++;
            }
        }
        int arr[] = new int[count];
        int pos = 0;
        for(int val : map.keySet()){
            if(map.get(val) == greatest){
                arr[pos++] = val;
            }
        }
        return arr;

    }
    public void find(TreeNode root){
        if(root == null)return;

        map.put(root.val,map.getOrDefault(root.val,0) + 1);

        find(root.left);
        find(root.right);
    }
}
