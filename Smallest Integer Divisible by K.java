class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0)return -1;

        int rem = 0;
        int size = 0;
        for(int i=0;i<k;i++){
            rem = (rem * 10 + 1) % k;
            size++;
            if(rem == 0)return size; 
        }
        return -1;
    }
}
