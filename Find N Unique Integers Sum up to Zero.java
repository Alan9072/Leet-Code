class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];

        int limit = n;
        if(n % 2 != 0){
            limit = n - 1;
            result[n - 1] = 0;
        }
        int idx = 0;
        for(int i=1;idx < limit;i++){
            result[idx] = i;
            result[idx + 1] = - i;
            idx += 2;
        }
        return result;

    }
}
