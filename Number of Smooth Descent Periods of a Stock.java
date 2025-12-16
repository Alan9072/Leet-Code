class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;

        int left = 0;
        int right = 0;
        for(right=0;right<prices.length;right++){
            
            if(left != right && prices[right] != prices[right - 1] - 1){
                long n = right - left;
                count += n * (n + 1)/2;
                left = right;
            }
        }
        long n = right - left;
        count += n * (n + 1)/2;

        return count;
    }
}
