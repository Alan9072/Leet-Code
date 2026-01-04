class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int val : nums) {
            int count = 0;
            int subSum = 0;
            for (int i = 2; i * i <= val; i++) {
                if (val % i == 0) {
                    if (i * i == val) {
                        count += 1;
                        subSum += i;
                    } else {
                        count += 2;
                        subSum += i + (val / i);
                    }
                }
            }

            if (count == 2) {
                subSum += 1 + val;
                sum += subSum;
            }

        }
        return sum;
    }
}
