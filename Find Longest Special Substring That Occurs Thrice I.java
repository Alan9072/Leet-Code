class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            for(int j=i;j<s.length();j++){
                char curr2 = s.charAt(j);
                if(curr != curr2)break;
                else{
                    sb.append(curr2);
                    String key = sb.toString();
                    map.put(key,map.getOrDefault(key,0)+1);
                }
            }
            sb.setLength(0);
        }
        int longest = -1;
        for(String val : map.keySet()){
            if(map.get(val) >= 3){
                longest = Math.max(val.length(),longest);
            }
        }
        return longest;

    }
}
