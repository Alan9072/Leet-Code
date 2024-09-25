class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char arr[] = strs[i].toCharArray();
            Arrays.sort(arr);
            String string = String.valueOf(arr);
            List<String> sublist = new ArrayList<>();
            if(!map.containsKey(string)){
                sublist.add(strs[i]);
                map.put(string,sublist);
            }
            else{
                map.get(string).add(strs[i]);
            }
            
        }
        List<List<String>> mainList = new ArrayList<>();
        for( List<String> val : map.values()){
            mainList.add(val);
        }
       
        return mainList;
    }
}
