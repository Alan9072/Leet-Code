class Pair {
    int src;
    int dest;
    int time;

    Pair(int src, int dest, int time) {
        this.src = src;
        this.dest = dest;
        this.time = time;
    }
}

class Router {
    Queue<Pair> q;
    Set<String> set;
    Map<Integer, List<Integer>> timeMap;
    int mLimit;

    public Router(int memoryLimit) {
        q = new LinkedList<>();
        set = new HashSet<>();
        timeMap = new HashMap<>();
        mLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;

        if (set.contains(key)) return false;

        if (q.size() >= mLimit) {
            Pair old = q.poll();
            set.remove(old.src + "#" + old.dest + "#" + old.time);
            List<Integer> list = timeMap.get(old.dest);
            if (list != null && !list.isEmpty()) {
                list.remove(0);
            }
        }

        Pair curr = new Pair(source, destination, timestamp);
        q.add(curr);

        timeMap.putIfAbsent(destination, new ArrayList<>());
        timeMap.get(destination).add(timestamp);

        set.add(key);
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[]{};

        Pair curr = q.poll();
        set.remove(curr.src + "#" + curr.dest + "#" + curr.time);

        List<Integer> list = timeMap.get(curr.dest);
        if (list != null && !list.isEmpty()) {
            list.remove(0);
        }

        return new int[]{curr.src, curr.dest, curr.time};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = timeMap.getOrDefault(destination, new ArrayList<>());
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);
        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
©leetcode
