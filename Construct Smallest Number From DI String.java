class Solution {
    private String result = null;

    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[10];
        StringBuilder sb = new StringBuilder();
        
        backtrack(used, pattern, sb);
        
        return result;
    }

    private void backtrack(boolean[] used, String pattern, StringBuilder sb) {
        if (result != null) return;

        int size = pattern.length() + 1;
        if (sb.length() == size) {
            if (isValid(sb, pattern)) {
                result = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (used[i]) continue;

            sb.append(i);
            used[i] = true;

            backtrack(used, pattern, sb);

            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean isValid(StringBuilder sb, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && sb.charAt(i) >= sb.charAt(i + 1)) {
                return false;
            }
            if (pattern.charAt(i) == 'D' && sb.charAt(i) <= sb.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
