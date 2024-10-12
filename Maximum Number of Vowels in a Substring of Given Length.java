class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < k; i++) {
             if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        maxCount = count;
        
        int left = 0;
        int right = k - 1;

        while (right < s.length()) {
          
            if (isVowel(s.charAt(left))){
                count--;
                    }
   
            left++;
            right++;
            if (right < s.length()) {
                if (isVowel(s.charAt(right))) {
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }

        }
        
        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
