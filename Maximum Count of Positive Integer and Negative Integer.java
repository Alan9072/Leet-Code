class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for(int val : nums){
            if(val > 0)pos++;
            else if(val < 0)neg++;
        }
        return Math.max(neg,pos);
    }
}
