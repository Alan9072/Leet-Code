class Solution {
    public String firstPalindrome(String[] words) {
        String palindrome = "";
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int flag = 0;
            for(int j=0;j<word.length()/2;j++){
                if(word.charAt(j) != word.charAt(word.length()-j-1)){
                    flag = 1;
                }
            }
            if(flag == 0)return word;
        }
        return palindrome;
    }
}
