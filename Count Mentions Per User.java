class Pair {
    int time;
    int id;

    Pair(int time, int id) {
        this.id = id;
        this.time = time;
    }
}

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2)
                return t1 - t2;

            if (a.get(0).equals("OFFLINE") && b.get(0).equals("MESSAGE"))
                return -1;
            if (a.get(0).equals("MESSAGE") && b.get(0).equals("OFFLINE"))
                return 1;

            return 0;
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        HashSet<Integer> online = new HashSet<>();
        for (int i = 0; i < numberOfUsers; i++) {
            online.add(i);
        }
        int[] result = new int[numberOfUsers];

        for (int i = 0; i < events.size(); i++) {
            List<String> event = events.get(i);

            int time = Integer.parseInt(event.get(1));
            while (!pq.isEmpty() && pq.peek().time + 60 <= time) {
                online.add(pq.poll().id);
            }

            if (event.get(0).equals("MESSAGE")) {

                String val = event.get(2);
                if (val.charAt(0) == 'i') {
                    String arr[] = val.split(" ");
                    for (String id : arr) {
                        int idx = Integer.parseInt(id.substring(2));
                        result[idx]++;
                    }

                } else if (val.equals("ALL")) {
                    for (int j = 0; j < numberOfUsers; j++) {
                        result[j]++;
                    }
                } else {

                    for (int onlineid : online) {
                        result[onlineid]++;
                    }
                }
            } else {
                online.remove(Integer.parseInt(event.get(2)));
                pq.add(new Pair(Integer.parseInt(event.get(1)), Integer.parseInt(event.get(2))));
            }
        }
        return result;
    }
}
