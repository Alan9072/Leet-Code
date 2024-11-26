class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        ArrayList<int[]> res2 = new ArrayList<>();
        int i=0;

        while(i < intervals.length && intervals[i][0] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        res.add(newInterval);

        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }

        int max = 0; 
        for(int j=0;j<res.size();j++){
            if(res2.isEmpty()){
                res2.add(res.get(j));
                max = res.get(j)[1];
            }
            else{
                if(res.get(j)[0] <= max){
                    int[] prev = res2.remove(res2.size() - 1);
                    max = Math.max(res.get(j)[1],prev[1]);
                    res2.add(new int[]{prev[0],max});
                   
                }else{
                    res2.add(res.get(j));
                    max = res.get(j)[1];
                }
            }

        }
        int[][] result = new int[res2.size()][2];

        int pos = 0;
        for (int[] val : res2) {
            result[pos] = val;
            pos++;
        }
        return result;
    }
}
