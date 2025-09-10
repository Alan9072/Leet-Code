class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashSet<Integer> needTeaching = new HashSet<>();

        for (int[] arr : friendships) {
            int u = arr[0], v = arr[1];
            if (!canCommunicate(languages[u - 1], languages[v - 1])) {
                needTeaching.add(u);
                needTeaching.add(v);
            }
        }

        int mainCount = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int person : needTeaching) {
                boolean knows = false;
                for (int l : languages[person - 1]) {
                    if (l == lang) {
                        knows = true;
                        break;
                    }
                }
                if (!knows) count++;
            }
            mainCount = Math.min(mainCount, count);
        }

        return mainCount == Integer.MAX_VALUE ? 0 : mainCount;
    }

    private boolean canCommunicate(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int lang : a) set.add(lang);
        for (int lang : b) if (set.contains(lang)) return true;
        return false;
    }
}
