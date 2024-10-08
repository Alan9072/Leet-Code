class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int val : piles){
            if(val > max){
                max = val;
            }
        }
        int left = 1;
        int right = max;
        while(left < right){
            int mid = (left + right)/2;
            if(canFinish(piles,h,mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            } 
        }
        return left;
    }
    public boolean canFinish(int[] piles,int h, int mid){
        int hours = 0;
        for( int pile : piles){
             hours += (pile + mid - 1) / mid;
        }
        return hours <= h;
    }
}
