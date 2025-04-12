class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0] - b[0]);
        int count = 1;
        int[] prev = pairs[0];
        for(int i=1;i<pairs.length;i++){
            int[] curr = pairs[i];

            if(prev[1] >= curr[0]){
                if(prev[1] > curr[1]){
                    prev = curr;
                }
            }else{
                count++;
                prev = curr;
            }
        }
        return count;
    }
}
