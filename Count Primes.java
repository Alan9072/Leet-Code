class Solution {
    public int countPrimes(int n) {
        int count = 0;

        boolean [] isPrime = new boolean[n];
        for(int i=0;i<n;i++){
            isPrime[i] = true;
        }

        for(int i=2;i<n;i++){
            if(isPrime[i] == true){
                count++;
                for(int j = i*2;j<n;j = j + i){
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
}
