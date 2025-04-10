class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int max = Math.min(word1.length(),word2.length());
        int i=0;
        for(i=0;i<max;i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(word1.length() > word2.length()){
            sb.append(word1.substring(i));
        }else{
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}
