class Pair {
    char val;
    int index;

    Pair(char val, int index) {
        this.val = val;
        this.index = index;
    }
}

class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.val == b.val)
                return b.index - a.index;
            else {
                return a.val - b.val;
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr != '*') {
                minHeap.add(new Pair(curr, i));
            } else {
                minHeap.poll();
            }
        }
        
        PriorityQueue<Pair> min = new PriorityQueue<>((a, b) -> {
            return a.index - b.index;
        });

        while (!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            min.add(curr);
        }

        while (!min.isEmpty()) {
            Pair curr = min.poll();
            sb.append(curr.val);
        }
        return sb.toString();
    }

}
