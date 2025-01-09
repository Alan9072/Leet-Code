class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String val : words){
            if(val.startsWith(pref))count++;
        }
        return count;
    }
}
