class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] arr = new int[intervals.length][2];
        int[] result = new int[intervals.length];

        for(int i=0;i<intervals.length;i++){
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b)->{
            return a[0] - b[0];
        });

        for(int i=0;i<intervals.length;i++){
            int[] curr = intervals[i];

            int left = 0;
            int right = intervals.length - 1;
            while(left <= right){
                int mid = left + (right - left) /2;
                if(arr[mid][0] < curr[1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if(left >= intervals.length){
                result[i] = -1;
            }else{
                result[i] = arr[left][1];
            }
            
        }
        return result;
    }
}
