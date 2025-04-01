class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!map.containsKey(curr)){
                if(map.containsValue(t.charAt(i)))return false;
                else{
                    map.put(curr,t.charAt(i));
                }
                
            }else{
                char fromMap = map.get(curr);
                if(t.charAt(i) != fromMap)return false;
            }
        }
        return true;
    }
}
