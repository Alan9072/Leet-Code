class Solution {
    public double separateSquares(int[][] squares) {
        double minY = Double.MAX_VALUE;
        double maxY = 0;
        double totalArea = 0;

        for (int[] curr : squares) {
            minY = Math.min(minY, curr[1]);
            maxY = Math.max(maxY, curr[1] + curr[2]);
            totalArea += (double) curr[2] * curr[2];
        }

        double eps = 1e-6;

        while (maxY - minY > eps) {
            double mid = minY + (maxY - minY) / 2;
            int val = possible(mid, squares, totalArea);

            if (val == 1) {
                minY = mid;   // need more area below
            } else {
                maxY = mid;   // valid or too much below → move down
            }
        }

        return (minY + maxY) / 2;
    }

    public int possible(double mid, int[][] squares, double area) {
        double lowArea = 0;

        for (int[] curr : squares) {
            double y = curr[1];
            double s = curr[2];

            if (mid > y && mid < y + s) {
                lowArea += (mid - y) * s;
            } else if (y + s <= mid) {
                lowArea += s * s;
            }
        }

        double upArea = area - lowArea;

        return upArea > lowArea ? 1 : 2;
    }
}
