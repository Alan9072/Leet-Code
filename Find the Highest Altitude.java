class Solution {
    public int largestAltitude(int[] gain) {
        int lvl = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            if (i == 0) {
                sum = gain[i];
                if (sum > lvl) {
                    lvl = sum;
                }
            } else {
                sum += gain[i];
                if (sum > lvl) {
                    lvl = sum;
                }
            }
        }
        return lvl;

    }
}
