class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int[] arr = new int[s.length()];
        int maxCount = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stk.push(i);
            }else if(s.charAt(i) == ')' && !stk.isEmpty()){
                arr[i] = 1;
                int index = stk.pop();
                arr[index] = 1;
            }
        }
        int count = 0;
        for(int val : arr){
            if(val == 1){
                count++;
                maxCount = Math.max(maxCount,count);
            }
            else{
                count = 0;
            }
        }
        return maxCount;
        
    }
}
