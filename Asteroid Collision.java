class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stk.isEmpty()) {
                stk.push(asteroids[i]);
            } else if (asteroids[i] > 0) {
                stk.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                int curr = asteroids[i];
                while (curr < 0 && !stk.isEmpty() && stk.peek() > 0) {
                    int val = stk.pop();
                    if (curr + val < 0) {
                        curr = curr;
                    } else if (curr + val > 0) {
                        curr = val;
                    } else {
                        curr = 0;
                    }
                }
                if (curr != 0)
                    stk.push(curr);
            }
        }
        
        int[] result = new int[stk.size()];
        for(int i=result.length - 1;i>=0;i--){
            result[i] = stk.pop();
        }
        return result;
    }
}
