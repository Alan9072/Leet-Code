/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int count = 0;

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null && q.isEmpty())
                break;
            List<Integer> subList = new ArrayList<>();
            while (curr != null) {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                subList.add(curr.val);
                curr = q.poll();
            }
            count += compute(subList);
            q.add(null);
        }
        return count;
    }

    public int compute(List<Integer> subList) {
        List<Integer> sorted = new ArrayList<>(subList);
        Collections.sort(sorted);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            indexMap.put(sorted.get(i), i);
        }

        int subCount = 0;

        for (int i = 0; i < subList.size(); i++) {
            if (subList.get(i).equals(sorted.get(i))) {
                continue;
            }

            while (!subList.get(i).equals(sorted.get(i))) {
                int correctIndex = indexMap.get(subList.get(i));
                int temp = subList.get(i);
                subList.set(i, subList.get(correctIndex));
                subList.set(correctIndex, temp);
                subCount++;
            }
        }

        return subCount;
    }
}
