class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            freq[curr - 'a']++;
        }

        int start = 0;
        while(start < t){
            int zCount = freq[25];
            freq[25] = 0;
            for(int i=25;i>0;i--){
                freq[i] = freq[i - 1];
            }
            freq[0] = zCount % MOD;
            freq[1] = (freq[1] + zCount) % MOD;

            start++;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            count = (count + freq[i]) % MOD;
        }
        return count;
    }
}
