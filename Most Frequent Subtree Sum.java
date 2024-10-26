
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);

        int maxFrequency = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (frequency > maxFrequency) {
                result.clear();
                maxFrequency = frequency;
                result.add(key);
            } else if (frequency == maxFrequency) {
                result.add(key);
            }
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int subtreeSum = root.val + leftSum + rightSum;

        map.put(subtreeSum, map.getOrDefault(subtreeSum, 0) + 1);

        return subtreeSum;
    }
}
