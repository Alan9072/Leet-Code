class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length + 1];
        int sum = 0;
        for(int i=0;i<words.length;i++){
            if(isVowel(words[i])){
                sum += 1;
            }
            prefixSum[i+1] = sum;
        }
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]]; 
        }
        return result;

    }

    public boolean isVowel(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        String vowels = "aeiou";
        return vowels.contains("" + s.charAt(0)) && vowels.contains("" + s.charAt(s.length() - 1));
    }
}
