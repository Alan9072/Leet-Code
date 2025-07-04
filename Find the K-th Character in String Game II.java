import java.math.BigInteger;

class Solution {
    public char kthCharacter(long k, int[] operations) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger val = two.pow(operations.length);
        
        int total = rec(val, BigInteger.valueOf(k), operations, two, operations.length - 1);
        int realAdd = total % 26;
        return (char)('a' + realAdd);
    }
    
    public int rec(BigInteger val, BigInteger k, int[] operations, BigInteger two, int pos) {
        
        if (pos < 0) {
            return 0;
        }
        
        BigInteger result = val.divide(two);
        
        if (k.compareTo(result) > 0) {
            BigInteger rem = k.subtract(result);
            if (operations[pos] == 1) {
                return 1 + rec(result, rem, operations, two, pos - 1);
            } else {
                return rec(result, rem, operations, two, pos - 1);
            }
        } else {
            return rec(result, k, operations, two, pos - 1);
        }
    }
}
