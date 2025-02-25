class Solution {
    public boolean increasingTriplet(int[] nums) {
       if(nums.length < 3) return false;
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;
       for(int n : nums) {
           if(n <= min1) min1 = n;
           else if(n <= min2) min2 = n;
           else return true;
       }
       return false;
    }
}
