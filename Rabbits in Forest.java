class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : answers){
            map.put(val,map.getOrDefault(val,0) + 1);
        }
        
        int count = 0;
        for(int key : map.keySet()){
            int newKey = key + 1;
            int val = map.get(key);
            if(val < newKey){
                count += newKey;
            }else{
                count += ((val + newKey - 1) / newKey) * newKey;
            }
        }
        return count;
    }
}
