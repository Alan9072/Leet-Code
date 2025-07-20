class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        boolean[] isPrime = sieve(n);

        long sumA = 0;
        long sumB = 0;

        for(int i=0;i<n;i++){
            if(isPrime[i]){
                sumA += nums[i];
            }else{
                sumB += nums[i];
            }
        }

        return Math.abs(sumA - sumB);
    }

    public boolean[] sieve(int n){
        boolean[] prime = new boolean[n];
        if(n > 0) prime[0] = false;
        if(n > 1) prime[1] = false;

        for(int i = 2;i<n;i++) prime[i] = true;

        for(int i = 2;i * i < n;i++){
            if(prime[i]){
                for(int j= i* i; j< n;j += i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
