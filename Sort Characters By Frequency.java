class Solution {
    public String frequencySort(String s) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1 );
        }
        for(char key:map.keySet()){
            maxHeap.add(key);
        }

        while(maxHeap.size() > 0){
            char word = maxHeap.poll();
            int count = 0;
            while(count < map.get(word)){
                sb.append(word);
                count++;
            }
        }
        return sb.toString();
    }
}
