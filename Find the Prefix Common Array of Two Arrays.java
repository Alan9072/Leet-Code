class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int freq[] = new int[A.length + 1];
        int result[] = new int[A.length];
        int count = 0;

        for(int i=0;i<A.length;i++){
            freq[A[i]] += 1;
            if(freq[A[i]] == 2)count++;

            freq[B[i]] += 1;
            if(freq[B[i]] == 2)count++;

            result[i] = count;
        }
        return result;
    }
}
