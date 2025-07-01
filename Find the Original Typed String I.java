class Solution {
    public int possibleStringCount(String word) {
        int count = 0;
        int start = 0;
        while(start < word.length()){
            int sub = start + 1;

            while(sub < word.length() && word.charAt(start) == word.charAt(sub)){
                sub++;
                count++;
            }
            start = sub;
        }
        return count + 1;
    }
}
