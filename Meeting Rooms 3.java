class Pair {
    int idx;
    long end;

    Pair(int idx, long end) {
        this.idx = idx;
        this.end = end;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.add(i);

        PriorityQueue<Pair> busy = new PriorityQueue<>(
            (a, b) -> a.end == b.end ? a.idx - b.idx : Long.compare(a.end, b.end)
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];

            while (!busy.isEmpty() && busy.peek().end <= start) {
                free.add(busy.poll().idx);
            }

            if (!free.isEmpty()) {
                int room = free.poll();
                count[room]++;
                busy.add(new Pair(room, end));
            } else {
                Pair p = busy.poll();
                count[p.idx]++;
                long duration = end - start;
                busy.add(new Pair(p.idx, p.end + duration));
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) ans = i;
        }
        return ans;
    }
}
