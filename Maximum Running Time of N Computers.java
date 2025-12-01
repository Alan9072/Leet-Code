class Solution {
    public long maxRunTime(int n, int[] batteries) {
        // int min = Integer.MAX_VALUE;
        // if(n == batteries.length){
        //     for(int val : batteries){
        //         min = Math.min(val,min);
        //     }
        //     return min;
        // }

        long limit = 0;
        for(int val : batteries){
            limit += val;
        }

        limit = limit / n;

        long result = 0;
        long left = 1;
        long right = limit;
        while(left <= right){
            long mid = left + (right - left)/2;

            if(possible(mid,batteries,n)){
                result = Math.max(result,mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }

    public boolean possible(long mid,int[] batteries,int n){

        long totalConsume = 0;
        for(int val : batteries){
            totalConsume += Math.min(mid,val);
        }

        if(totalConsume >=  (long) mid * n)return true;
        return false;
    }
}
