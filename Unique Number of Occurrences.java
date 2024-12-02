class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val,0) + 1);
        }
        for(int val:map.values()){
            set.add(val);
        }

        return map.size() == set.size();

    }
}
