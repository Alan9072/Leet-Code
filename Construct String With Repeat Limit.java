class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for (char key : map.keySet()) {
            maxHeap.add(key);
        }
        while (!maxHeap.isEmpty()) {
            char curr = maxHeap.poll();
            int count = 0;
            while (map.get(curr) > 0 && count < repeatLimit) {
                sb.append(curr);
                map.put(curr, map.get(curr) - 1);
                count++;
            }
            if (map.get(curr) > 0) {
                if (!maxHeap.isEmpty()) {
                    char next = maxHeap.poll();
                    sb.append(next);
                    map.put(next, map.get(next) - 1);

                    if(map.get(next) > 0){
                        maxHeap.add(next);
                    }
                    maxHeap.add(curr);
                }
                
            }else{
                map.remove(curr);
            }

        }

        return sb.toString();
    }
}
