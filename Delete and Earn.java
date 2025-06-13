class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        int[] arr = new int[map.size()];

        int index = 0;
        for (int key : map.keySet()) {
            arr[index] = key;
            index++;
        }
        Arrays.sort(arr);
        int lastVal = arr[arr.length - 1];
        int[] dp = new int[lastVal];
        Arrays.fill(dp, -1);
        return dfs(0, arr, dp, map);
    }

    public int dfs(int index, int[] arr, int[] dp, HashMap<Integer, Integer> map) {

        if (index >= arr.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];

        int chosen = arr[index] * map.get(arr[index]);
        int nextIndex = index + 1;

        // If next number is consecutive, we must skip it
        if (nextIndex < arr.length && arr[nextIndex] == arr[index] + 1) {
            chosen += dfs(index + 2, arr, dp, map);
        } else {
            chosen += dfs(index + 1, arr, dp, map);
        }
        int notChosen = dfs(index + 1, arr, dp, map);

        return dp[index] = Math.max(chosen, notChosen);
    }
}
