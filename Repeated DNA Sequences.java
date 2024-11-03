class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        if(s.length() <= 10){
            return list;
        }

        int start = 0;
        int end = 0;
        int length = 0;
        while(length != 10){
            length++;
            end++;
        }
        for(int i = end;end <= s.length();end++){
            String sub = s.substring(start,end);
            if(set.contains(sub)){
                if(!list.contains(sub)){
                    list.add(sub);
                }
                
            }else{
                 set.add(sub);
            }
            start++;
        }
        return list;
    }
}
