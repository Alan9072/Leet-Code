class Solution {
    public char kthCharacter(long k, int[] operations) {
        long val = 1;
        int idx = 0;
        while (val < k) {
            val *= 2;
            idx++;
        }
                
        int total = rec(val, k, operations,idx - 1);
        int realAdd = total % 26;
        return (char) ('a' + realAdd);
    }

    public int rec(long val, long k, int[] operations, int pos) {

        if (pos < 0) {
            return 0;
        }

        long result = val / 2;

        if (k > result) {
            long rem = k - result;
            if (operations[pos] == 1) {
                return 1 + rec(result, rem, operations, pos - 1);
            } else {
                return rec(result, rem, operations, pos - 1);
            }
        } else {
            return rec(result, k, operations, pos - 1);
        }
    }
}
