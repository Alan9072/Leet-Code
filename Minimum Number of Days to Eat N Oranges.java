class Solution {
    public int minDays(int n) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private int dfs(long n, Map<Long, Integer> memo) {
        if (n <= 1) return (int)n;
        if (memo.containsKey(n)) return memo.get(n);

        int days = 1 + Math.min(
            (int)(n % 2) + dfs(n / 2, memo),
            (int)(n % 3) + dfs(n / 3, memo)
        );

        memo.put(n, days);
        return days;
    }
}
