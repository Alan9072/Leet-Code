class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) Math.pow(10, 14);
        long realTime = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;

            for (int rank : ranks) {
                sum += Math.sqrt(mid / rank);
                if (sum >= cars) break; 
            }

            if (sum >= cars) {
                realTime = mid; 
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return realTime;
    }
}
