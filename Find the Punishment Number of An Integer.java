class Solution {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (isPossible(i * i, i)) {
                total += i * i;
            }
        }
        return total;
    }

    public boolean isPossible(int square, int target) {
        return canFind(0, 0, String.valueOf(square), target);
    }

    public boolean canFind(int sum, int index, String number, int target) {
        if (index == number.length()) {
            return sum == target;
        }

        int num = 0;
        for (int i = index; i < number.length(); i++) {
            num = num * 10 + Integer.parseInt(""+number.charAt(i));
            if (canFind(sum + num, i + 1, number, target)) {
                return true;
            }
        }
        return false;
    }
}
