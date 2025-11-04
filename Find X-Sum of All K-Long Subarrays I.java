class Pair {
    int nVal;
    int freq;
    Pair(int nVal, int freq) {
        this.nVal = nVal;
        this.freq = freq;
    }
}

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int len = nums.length - k + 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = xsum(i, nums, k, x);
        }
        return result;
    }

    public int xsum(int idx, int[] nums, int k, int x) {
        int[] demo = new int[51];
        for (int i = idx; i < idx + k; i++) {
            demo[nums[i]]++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->
            a.freq != b.freq ? b.freq - a.freq : b.nVal - a.nVal
        );

        for (int i = 1; i <= 50; i++) {
            if (demo[i] > 0) pq.add(new Pair(i, demo[i]));
        }

        int sum = 0;
        int count = 0;
        while (count < x && !pq.isEmpty()) {
            Pair val = pq.poll();
            sum += val.nVal * val.freq;
            count++;
        }
        return sum;
    }
}
