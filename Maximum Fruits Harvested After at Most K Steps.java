class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int last = fruits[fruits.length - 1][0];
        int maxReach = Math.max(last, startPos + k); // maximum index we might reach
        int[] prefix = new int[maxReach + 1]; // size based on reachable max index

        for (int i = 0; i < fruits.length; i++) {
            int index = fruits[i][0];
            int amount = fruits[i][1];
            prefix[index] = amount;
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        int max = 0;

        // Left-first movement
        int start = startPos;
        int count = 0;
        while (start >= 0 && count <= k) {
            int rightSteps = k - 2 * count;
            if (rightSteps < 0) break; // stop when no moves left
            int rightPos = Math.min(maxReach, startPos + rightSteps);
            max = Math.max(max, prefix[rightPos] - (start > 0 ? prefix[start - 1] : 0));
            start--;
            count++;
        }

        // Right-first movement
        start = startPos;
        count = 0;
        while (start <= maxReach && count <= k) {
            int leftSteps = k - 2 * count;
            if (leftSteps < 0) break; // stop when no moves left
            int leftPos = Math.max(0, startPos - leftSteps);
            max = Math.max(max, prefix[start] - (leftPos > 0 ? prefix[leftPos - 1] : 0));
            start++;
            count++;
        }

        return max;
    }
}
