class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder abc = new StringBuilder(s);
        int i=0;
        while(i<abc.length()){
            if(abc.charAt(i) == ' '){
                i++;
            }
            else{
                int start = i;
                int pos = i;
                int count = 0;
                while(pos < abc.length() && abc.charAt(pos)!=' '){
                    count++;
                    pos++;
                }
                list.add(abc.substring(start,pos));
                i = i + count;
            } 
        }
        
        StringBuilder result = new StringBuilder();
        for (int j = list.size() - 1; j >= 0; j--) {
            result.append(list.get(j));
            if (j > 0) { 
                result.append(" ");
            }
        }

        return result.toString();
    }
   
}
