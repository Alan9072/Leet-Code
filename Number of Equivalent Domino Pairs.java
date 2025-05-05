class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            String curr = dominoes[i][0]+ "#" +dominoes[i][1];
            String rev = dominoes[i][1]+ "#" +dominoes[i][0];
            if(map.containsKey(rev)){
                map.put(rev,map.getOrDefault(rev,0) + 1);
            }
            else {
                map.put(curr,map.getOrDefault(curr,0) + 1);
            }
            
        }
        int count = 0;
        for(String key : map.keySet()){
            if(map.get(key) > 1){
                int n = map.get(key);
                count += (n-1)* (n)/2;
            }
        }
        return count;
    }
}
