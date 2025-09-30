class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {

            int curr = heights[i];
            if (stk.isEmpty()) {
                result[i] = 0;
            } else if (stk.peek() <= curr) {
                int count = 0;
                while (!stk.isEmpty() && stk.peek() <= curr) {
                    stk.pop();
                    count++;
                }
                result[i] = stk.isEmpty() ? count : count + 1;
            } else {
                result[i] = 1;
            }
            stk.push(curr);
        }
        return result;
    }
}
