class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("");
        int start = 1;
        while(start <= n){
            if(start == 1){
                sb.append("1");
            }
            if(start > 1){
                sb = new StringBuilder(help(sb.toString()));
            }
            start++;
        }
        return sb.toString();
    }
    public String help(String word){
        StringBuilder sb2 = new StringBuilder("");
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            int count = 0;
            while(i<word.length() && word.charAt(i) == curr){
                count++;
                i++;
            }
            i = i - 1;
            sb2.append(count);
            sb2.append(curr);
        }
        return sb2.toString();
    }
}
