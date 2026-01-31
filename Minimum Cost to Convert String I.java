class Pair {
    char node;
    long weight;

    Pair(char node, long weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        Map<Character, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < original.length; i++) {
            if (!graph.containsKey(original[i])) {
                graph.put(original[i], new ArrayList<>());
                graph.get(original[i]).add(new Pair(changed[i], cost[i]));
            } else {
                List<Pair> sub = graph.get(original[i]);
                int found = -1;

                for (int j = 0; j < sub.size(); j++) {
                    if (sub.get(j).node == changed[i]) {
                        found = 1;
                        if (sub.get(j).weight > cost[i]) {
                            sub.get(j).weight = cost[i];
                        }
                    }
                }
                if (found == -1) {
                    graph.get(original[i]).add(new Pair(changed[i], cost[i]));
                }
            }
        }
        long[][] arr = new long[26][26];

        for (int i = 0; i < 26; i++)
            Arrays.fill(arr[i], Long.MAX_VALUE);

        for (int i = 0; i < 26; i++)
            arr[i][i] = 0;
        
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i == j)continue;

                char st = (char) ('a' + i);
                char ed = (char) ('a' + j);
                find(st,ed,graph,arr);
            }
        }

        long min = 0;
        for (int i = 0; i < source.length(); i++) {//dijstra for shortest path
            if (source.charAt(i) != target.charAt(i)) {
                long val = arr[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (val == Long.MAX_VALUE)
                    return -1;
                min += val;
            }
        }
        return min;
    }

    public long find(char st, char ed, Map<Character, List<Pair>> graph,long[][] arr) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.weight, b.weight));
        pq.add(new Pair(st, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            char ch = curr.node;
            long weight = curr.weight;
            if (!graph.containsKey(ch))
                continue;

            List<Pair> sub = graph.get(ch);

            for (int i = 0; i < sub.size(); i++) {
                Pair neigh = sub.get(i);
                long ndist = neigh.weight + weight;

                if (ndist < arr[st - 'a'][neigh.node - 'a']) {
                    arr[st - 'a'][neigh.node - 'a'] = ndist;
                    pq.add(new Pair(neigh.node, ndist));
                }
            }

        }

        return arr[st - 'a'][ed - 'a'] == Long.MAX_VALUE ? -1 : arr[st - 'a'][ed - 'a'];

    }
}
