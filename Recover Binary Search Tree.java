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
    int valid1 = -1;
    int valid2 = -1;

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        int first = -1;
        int second = -1;
        for(int i=0;i<list.size();i++){
            if(list.get(i) != sorted.get(i)){
                first = list.get(i);
                second = sorted.get(i);
                break;
            }
        }
        valdfs(root,first,second);
    }
    public void valdfs(TreeNode root,int first,int second){
        if(root == null)return;

        if(valid1 == -1 && root.val == first){
            valid1 = 1;
            root.val = second;
        }
        else if(valid2 == -1 && root.val == second){
            valid2 = 1;
            root.val = first;
        }
        valdfs(root.left,first,second);
        valdfs(root.right,first,second); 


    }
    public void dfs(TreeNode root,List<Integer> list){
        if(root == null)return;

        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
