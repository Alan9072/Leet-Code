class Solution {
    public int numSub(String s) {
        int MOD = 1000000007;
        long count = 0;

        long sub = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') sub++;
            else {
                count = (count + (sub * (sub + 1) / 2) % MOD) % MOD;
                sub = 0;
            }
        }

        if (sub > 0) {
            count = (count + (sub * (sub + 1) / 2) % MOD) % MOD;
        }

        return (int) count;
    }
}
