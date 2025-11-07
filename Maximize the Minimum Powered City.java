class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] prefix = new long[n];
        long[] powers = new long[n];

        prefix[0] = stations[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + stations[i];

        for (int i = 0; i < n; i++) {
            long left = (i - r - 1 < 0) ? 0 : prefix[i - r - 1];
            long right = (i + r <= n - 1) ? prefix[i + r] : prefix[n - 1];
            powers[i] = right - left;
        }

        long left = 0, right = 0;
        for (int s : stations) right += s;
        right += k;

        long sol = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (possible(mid, powers, k, r)) {
                sol = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return sol;
    }

    public boolean possible(long val, long[] powers, long k, int r) {
        int n = powers.length;
        long[] added = new long[n];
        long currAdd = 0;
        long rem = k;

        for (int i = 0; i < n; i++) {
            if (i - r - 1 >= 0) currAdd -= added[i - r - 1];
            long total = powers[i] + currAdd;
            if (total < val) {
                long need = val - total;
                if (need > rem) return false;
                rem -= need;
                currAdd += need;
                added[Math.min(i + r, n - 1)] += need;
            }
        }
        return true;
    }
}
