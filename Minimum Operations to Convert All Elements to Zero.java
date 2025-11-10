class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                if(stk.size() > 0){
                    cnt += stk.size();
                    while(!stk.isEmpty())stk.pop();
                }
            }
            else if(stk.isEmpty() || stk.peek() < nums[i]){
                stk.push(nums[i]);
            }else{
                while(!stk.isEmpty() && stk.peek() >= nums[i]){
                    if(stk.peek() > nums[i]){
                        cnt++;
                    }
                    stk.pop();
                }
                stk.push(nums[i]);
            }
        }
        cnt += stk.size();
        return cnt;
    }
}
