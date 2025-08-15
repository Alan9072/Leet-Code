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
    int row;
    int col;
    int val;
    Pair(int row,int col,int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Pair> list = new ArrayList<>();
        dfs(root,0,0,list);
        Collections.sort(list,(a,b)->{
            if(a.col == b.col){
                if(a.row == b.row){
                    return a.val - b.val;
                }

                return a.row - b.row;
            }

            return a.col - b.col;
        });

        for(int i=0;i<list.size();i++){
            List<Integer> sub = new ArrayList<>();
            Pair curr = list.get(i);

            sub.add(curr.val);

            int j = i + 1;
            while(j < list.size() && list.get(j).col == curr.col){
                sub.add(list.get(j).val);
                j++;
                i++;
            }
            result.add(sub);
        }

        return result;

    }
    public void dfs(TreeNode root,int row,int col,List<Pair> list){
        if(root == null)return;

        Pair curr = new Pair(row,col,root.val);
        list.add(curr);

        dfs(root.left,row + 1,col - 1,list);
        dfs(root.right,row + 1,col + 1,list);

    }
}
