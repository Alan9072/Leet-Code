class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] dup = new int[arr.length];
        int[] dup2 = new int[arr.length];
        int count = 0;

        int sum = 0;
        for(int i=0;i<dup.length;i++){
            sum += arr[i];
            dup[i] = sum; 
        }
        sum = 0;
        for(int i=0;i<dup.length;i++){
            sum += i;
            dup2[i] = sum; 
        }
        for(int i=0;i<dup.length;i++){
            if(dup[i] == dup2[i])count++; 
        }
        return count;



    }
}
