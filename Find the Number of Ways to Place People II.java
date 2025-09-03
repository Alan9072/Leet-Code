class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int count = 0;

        for(int i=0;i<points.length;i++){
            int ymin = Integer.MIN_VALUE;
            int ymax = points[i][1];

            for(int j=i+1;j<points.length;j++){

                if(points[i][0] <= points[j][0] && points[i][1] >= points[j][1] && points[j][1] > ymin && points[j][1] <= ymax){
                    ymin = points[j][1];
                    count++;
                }
            }
        }
        return count;
    }
}
