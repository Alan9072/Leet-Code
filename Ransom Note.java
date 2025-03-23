class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char curr = magazine.charAt(i);
            map.put(curr,map.getOrDefault(curr,0) + 1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char curr = ransomNote.charAt(i);
            if(!map.containsKey(curr)){
                return false;
            }else{
                map.put(curr,map.get(curr) - 1);
                if(map.get(curr)== 0){
                    map.remove(curr);
                }
            }
        }
        return true;
    }
}
