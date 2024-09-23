
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;

        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<word1.length();i++){
            if(!map.containsKey(word1.charAt(i))){
                map.put(word1.charAt(i),1);
            }
            else{
                map.put(word1.charAt(i),map.get(word1.charAt(i))+1);
            }
        }
       
        for(int i=0;i<word2.length();i++){
            if(map.containsKey(word2.charAt(i))){
                if(!map2.containsKey(word2.charAt(i))){
                    map2.put(word2.charAt(i),1);
                }
                else{
                    map2.put(word2.charAt(i),map2.get(word2.charAt(i))+1);
                }
            }
            else{
                return false;
            }
        }
        List<Integer> valuesList1 = new ArrayList<>(map.values());
        List<Integer> valuesList2 = new ArrayList<>(map2.values());
        
        Collections.sort(valuesList1);
        Collections.sort(valuesList2);
        
        return valuesList1.equals(valuesList2);
        
    }
}
