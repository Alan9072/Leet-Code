class Solution {
    public int takeCharacters(String s, int k) {
        int maxLen = 0;
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a++;
            else if (s.charAt(i) == 'b') b++;
            else c++;
        }

        if (a < k || b < k || c < k) return -1;

        int left = 0, A = a, B = b, C = c;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == 'a') A--;
            else if (s.charAt(right) == 'b') B--;
            else C--;

            while (A < k || B < k || C < k) {
                if (s.charAt(left) == 'a') A++;
                else if (s.charAt(left) == 'b') B++;
                else C++;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return s.length() - maxLen;
    }
}
