class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        int bitMask = 1;
        while(bitMask != 0){
            if((n & bitMask) != 0)count++;
            bitMask <<= 1; 
        }
        return count;
    }
}
