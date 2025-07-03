class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        while(word.length() < k){
            StringBuilder next = new StringBuilder();
            for(int i=0;i<word.length();i++){
                char curr = word.charAt(i);
                if(curr == 'z'){
                    next.append('a');
                }else{
                    next.append((char)(curr + 1));
                }
            }
            word += next.toString();
        }
        return word.charAt(k - 1);
    }
}
