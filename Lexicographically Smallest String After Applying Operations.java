class Solution {
    String min = "";
    HashSet<String> set = new HashSet<>();

    public String findLexSmallestString(String s, int a, int b) {
        dfs(s, a, b);
        for (String sub : set) {
            if (min.equals("") || sub.compareTo(min) < 0) {
                min = sub;
            }
        }
        return min;
    }

    public void dfs(String s, int a, int b) {
        if (set.contains(s)) return;
        else set.add(s);

        String rotated = s.substring(s.length() - b) + s.substring(0, s.length() - b);
        dfs(rotated, a, b);

        StringBuilder sb2 = new StringBuilder(s);
        for (int i = 0; i < sb2.length(); i++) {
            if (i % 2 != 0) {
                int curr = sb2.charAt(i) - '0';
                int sum = curr + a;
                int rem = sum % 10;
                sb2.setCharAt(i, (char) (rem + '0'));
            }
        }

        dfs(sb2.toString(), a, b);
    }
}
