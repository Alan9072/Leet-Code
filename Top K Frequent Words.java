class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            if (map.get(a) == map.get(b)) {
                return a.compareTo(b);
            } else {
                return map.get(b) - map.get(a);
            }
        });

        for (String val : map.keySet()) {
            maxHeap.add(val);
        }

        List<String> list = new ArrayList<>();

        int size = maxHeap.size();
        while (maxHeap.size() > size - k) {
            list.add(maxHeap.poll());
        }

        return list;
    }
}
