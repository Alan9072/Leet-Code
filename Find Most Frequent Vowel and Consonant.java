class Solution {
    public int maxFreqSum(String s) {
        int v = 0;
        int c = 0;
        int[] letters = new int[26];
        for(int i=0;i<s.length();i++){
            letters[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++){
            char curr = (char) (i + 'a');

            if(isVowel(curr)){
                v = Math.max(v,letters[i]);
            }else{
                c = Math.max(c,letters[i]);
            }
        }
        return v + c;
    }
    public boolean isVowel(char ch){
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
