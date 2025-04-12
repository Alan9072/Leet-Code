class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int count = 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= prev[0] && curr[1] <= prev[1]){
                count++;
            }else{
                prev = curr;
            }
        }
        return intervals.length - count;
    }
}
///////////////////////////Common Approach //////////////////////////////////
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] prev = intervals[0];
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (prev[0] <= curr[0] && prev[1] >= curr[1]) {
                count++;
            }

            else if (curr[0] <= prev[0] && curr[1] >= prev[1]) {
                count++;
                prev = curr;
            }

            else {
                prev = curr;
            }
        }

        return intervals.length - count;
    }
}

