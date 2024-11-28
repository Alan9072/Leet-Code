class Solution {
    public int[] countBits(int n) {
        int result[] = new int[n+1];
        result[0] = 0;
        for(int i=1;i<=n;i++){
            int number = i;
            int count = 0;
            while(number != 0){
               number = number & (number - 1);
               count++;
            }
            result[i] = count;
        }
        return result;
    }
}
