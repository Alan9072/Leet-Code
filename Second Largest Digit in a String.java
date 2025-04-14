class Solution {
    public int secondHighest(String s) {
        int maxDigit = -1, secondMaxDigit = -1;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                if (digit == maxDigit || digit == secondMaxDigit) continue;
                if (maxDigit == -1) maxDigit = digit;
                else if (digit > maxDigit) {
                    secondMaxDigit = maxDigit;
                    maxDigit = digit;
                } else if (digit > secondMaxDigit && digit < maxDigit) {
                    secondMaxDigit = digit;
                }
            }
        }
        return secondMaxDigit;
    }
}
