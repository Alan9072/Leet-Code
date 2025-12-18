class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long prefix[] = new long[prices.length];
        prefix[0] = prices[0] * strategy[0];

        for (int i = 1; i < prices.length; i++) {
            prefix[i] = prefix[i - 1] + prices[i] * strategy[i];
        }

        long maxP = prefix[prices.length - 1];
        int end = k - 1;
        long innerSum = 0;

        int j = 0;
        for (int i = 0; i <= prices.length - k; i++) {

            long subSum = prefix[prices.length - 1] - prefix[end] + ((i == 0) ? 0 : prefix[i-1]);

            if (i == 0) {
                for (j = k / 2; j < k; j++) {
                    innerSum += prices[j];
                }
                subSum += innerSum;
            }else{
                innerSum += prices[j];
                innerSum -= prices[j - k/2];
                j++;

                subSum += innerSum;
            }

            maxP = Math.max(maxP,subSum);

            end++;

        }

        return maxP;
    }
}
