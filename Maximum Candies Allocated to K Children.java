class Solution {
    public int maximumCandies(int[] candies, long k) {
       long sum = 0;
       long max = 0;
       long solution = 0;
       for(long val : candies){
        sum += val;
        max = Math.max(val,max);
       }

       if(sum < k)return 0;

       long left = 1;
       long right = max;
       while(left <= right){
            long mid = left + (right - left)/2;

            ////////////////////////////////////////
            long count = 0;
            for( long val : candies){
                count += (val / mid);
            }
            if(count >= k){
                solution = Math.max(mid,solution);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
       }
       return (int) solution; 
    }
}
