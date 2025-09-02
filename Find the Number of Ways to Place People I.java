class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int pairs = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int valid = 1;
                if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == j)
                            continue;
                        
                        int[] mid = points[k];

                        if(mid[0] >= points[i][0] && mid[0] <= points[j][0] && mid[1] >= points[j][1] && mid[1] <= points[i][1]){
                            valid = 0;
                            break;
                        }
                    }
                }else{
                    continue;
                }

                if(valid == 1){
                    pairs++;
                }

            }
        }
        return pairs;
    }
}
