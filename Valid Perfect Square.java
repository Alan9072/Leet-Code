class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = 1 + num / 2;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long val = mid * mid;
            if(val == num){
                return true;
            }else if(val < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
