class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->a[0]- b[0]);
        ArrayList<int[]> arr = new ArrayList<>();
    
        int max = 0; 
        for(int i=0;i<intervals.length;i++){
            if(arr.isEmpty()){
                arr.add(intervals[i]);
                max = intervals[i][1];
            }
            else{
                if(intervals[i][0] <= max){
                    int[] prev = arr.remove(arr.size() - 1);
                    max = Math.max(intervals[i][1],prev[1]);
                    arr.add(new int[]{prev[0],max});
                   
                }else{
                    arr.add(intervals[i]);
                    max = intervals[i][1];
                }
            }
        }
        int[][] result = new int[arr.size()][2];
        int pos = 0;
        
        for (int[] val : arr) {
            result[pos] = val;
            pos++;
        }
        return result;
    }
}
