import java.util.HashMap;
import java.util.Collections;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int greatest = 0;
        int maxFre = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            maxFre = Math.max(maxFre, map.get(curr));

            int windowLength = right - left + 1;
            if (windowLength - maxFre > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            greatest = Math.max(greatest, right - left + 1);
        }
        return greatest;
    }
}
