class Solution {
    public long distributeCandies(int n, int limit) {
        long sum = 0;
        for(int i=0;i<=Math.min(n,limit);i++){
            sum += Math.max(Math.min(limit,n - i) - Math.max(0,n - i - limit) + 1,0);
        }
        return sum;
    }
}
