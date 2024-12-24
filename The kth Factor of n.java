class Solution {
    public int kthFactor(int n, int k) {
        int curr = 0;
        for(int i=1;i<=n;i++){
            if(n % i == 0){
                curr++;
            }
            if(curr == k){
                return i;
            }
        }
        return -1;
    }
}
