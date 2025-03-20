class Solution {
    public int hIndex(int[] citations) {
        int max = 0;
        Arrays.sort(citations);
        for(int i=citations.length - 1; i >= 0;i--){
            int paperNumber = citations.length - i;
            int citationRec = citations[i];
            if(citationRec >= paperNumber){
                max = Math.max(max,paperNumber);
            }
        }
        return max;
    }
}
