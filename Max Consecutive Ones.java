class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0;
        int sub = 0;
        for(int val : nums){
            if(val == 1){
                sub++;
                ones = Math.max(sub,ones);
            }else{
                sub = 0;
            }
            
        }
        return ones;
    }
}
