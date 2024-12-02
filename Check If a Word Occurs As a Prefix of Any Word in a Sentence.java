class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for(int i=0;i<arr.length;i++){
            String curr = arr[i];
            if(curr.length() < searchWord.length())continue;
            int strt = 0;
            while(strt < searchWord.length() && searchWord.charAt(strt) == curr.charAt(strt)){
                strt++;
            }
            if(strt == searchWord.length()){
                return i+1;
            }
        }
        return -1;
    }
}
