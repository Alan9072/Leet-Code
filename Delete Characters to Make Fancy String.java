class Solution {
    public String makeFancyString(String s) {
        StringBuilder string = new StringBuilder("");
        
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            int start = i;
            int end = start;
            while( end < s.length() && s.charAt(end) == curr){
                end++;
            }
            if((end - start) >=3){
                string.append(curr);
                string.append(curr);
                i = end - 1;

            }
            else{
                string.append(s.substring(start,end));
                i = end - 1;
            }
        }
        return string.toString();
    }
}
