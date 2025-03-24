class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(points[0]);
        int arrow = 1;

        for(int i=1;i<points.length;i++){
            int[] curr = points[i];
            int[] last = list.get(list.size() - 1);

            if((last[1] <= curr[1] && last[1] >= curr[0]) || last[1] >= curr[1]){
                int start = Math.max(last[0],curr[0]);
                int end = Math.min(last[1],curr[1]);
                int[] sub = new int[]{start,end};
                list.remove(list.size() - 1);
                list.add(sub);
            }else{
                list.add(points[i]);
                arrow++;
            }
        }
        return arrow;
    }
}

//////////////////////////////////////
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));//Integer.compare(x[])
        int hitPoint = points[0][1];
        int count = 1;
        for(int i = 1; i<points.length; i++){
            if(points[i][0] > hitPoint){
                count++;
                hitPoint = points[i][1];
            }
        }
        return count;
    }
}
