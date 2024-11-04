class Solution {
    public String compressedString(String word) {
        StringBuilder string = new StringBuilder();
        int start = 0;
        while(start < word.length()){
            char curr = word.charAt(start);
            int count = 1;
            //condition for not exceeding
            while((start + 1) < word.length() &&  word.charAt(start + 1) == curr && count < 9){
                start++;
                count++;
            }
            string.append(count);
            string.append(curr);

            start++;

        }
        return string.toString();
    }
}
