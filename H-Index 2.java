class Solution {
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int max = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            int rightLength = citations.length - mid;
            if(citations[mid] >= rightLength){
                max = Math.max(max,rightLength);
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return max;
    }
}
