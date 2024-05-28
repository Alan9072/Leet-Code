class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Handle the case where the last digit is less than 9
        if (digits[n - 1] < 9) {
            digits[n - 1]++;
            return digits;
        }

        // Handle the case where the last digit is 9
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        // Check if there is still a carry after the loop
        if (carry > 0) {
            // If there is, we need to create a new array with an additional digit
            int[] result = new int[n + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, n);
            return result;
        } else {
            return digits;
        }
    }
}
