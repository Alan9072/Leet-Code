import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                
                int index = stack.pop();
                result[index] = nums[i % n];
            }

            
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
