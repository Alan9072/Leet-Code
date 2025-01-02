class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : hand){
            map.put(val,map.getOrDefault(val,0) + 1);
        }
        Arrays.sort(hand);
        int size = 0;
        for(int i=0;i<hand.length;i++){
            int curr = hand[i];
            if(map.containsKey(curr) == false)continue;
            for(int j=curr;j<curr + groupSize;j++){
                if(map.containsKey(j) == false)return false;
                else{
                    size++;
                    map.put(j,map.get(j) - 1);
                    if(map.get(j) == 0){
                        map.remove(j);
                    }
                }
            }
        }
        if(size == hand.length)return true;
        return false;
    }
}
