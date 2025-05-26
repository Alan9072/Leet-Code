class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Pair> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            if(map.containsKey(curr)){
                Pair current = map.get(curr);
                current.first = current.first + 1;
            }else if(map.containsKey(curr.charAt(1) +""+ curr.charAt(0))){
                Pair current = map.get(curr.charAt(1) +""+ curr.charAt(0));
                current.second = current.second + 1;
            }else{
                map.put(curr, new Pair(1,0));
            }
        }
        int length = 0;
        boolean odd = false;

        for( String key : map.keySet()){
            if(key.charAt(0) != key.charAt(1)){
                if(map.get(key).first != 0 && map.get(key).second != 0){
                    length += Math.min(map.get(key).first , map.get(key).second);
                }
            }else{
                if(map.get(key).first % 2 != 0){
                    odd = true;
                }
                length += (map.get(key).first / 2);
            }

        }
        length = length * 4;
        if(odd){
            length += 2;
        }
        return length;
    }
}
