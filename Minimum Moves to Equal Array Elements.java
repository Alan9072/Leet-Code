class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int val : nums){
            min = Math.min(val,min);
        }
        for(int val : nums){
            sum += (val - min); 
        }
        return sum;
    }
}
