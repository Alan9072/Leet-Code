class Solution {
    public int findLHS(int[] nums) {
        int longest = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0) + 1);
        }

        for(int key : map.keySet()){
            if(map.containsKey(key + 1)){
                longest = Math.max(longest,map.get(key) + map.get(key + 1));
            }
        }
        return longest;
    }
}
