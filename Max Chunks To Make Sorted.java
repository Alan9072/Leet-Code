class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i)
                count++;
        }

        return count;
    }
}
///////////////////////////////////////////////////
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
