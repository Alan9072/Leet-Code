class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1000000007;
        List<Integer> list = new ArrayList<>();
        int temp = n;

        while (temp > 0) {
            int pow = 1;
            while (pow * 2 <= temp) {
                pow *= 2;
            }
            list.add(pow);
            temp -= pow;
        }

        Collections.sort(list);

        int[] prefix = new int[list.size()];
        prefix[0] = list.get(0) % MOD;

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = (int) (((long) prefix[i - 1] * list.get(i)) % MOD);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            int idx2 = queries[i][1];
            int idx1 = queries[i][0];

            if (idx1 == 0) {
                result[i] = prefix[idx2];
            } else {
                long prod = 1;
                for (int j = idx1; j <= idx2; j++) {
                    prod = (prod * list.get(j)) % MOD;
                }
                result[i] = (int) prod;
            }
        }
        return result;
    }
}
