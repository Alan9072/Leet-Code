class Solution {
    public static boolean isVowel(char c) {
        return "aeiouAEIOU".contains(String.valueOf(c));
    }
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(left < right){
            char leftc = s.charAt(left); 
            char rightc = s.charAt(right);
            if(!isVowel(leftc)){
                left++;
            }
            if(!isVowel(rightc)){
                right--;
            }
            if(isVowel(leftc) && isVowel(rightc)){

                sb.setCharAt(left,rightc);
                sb.setCharAt(right,leftc);
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}
