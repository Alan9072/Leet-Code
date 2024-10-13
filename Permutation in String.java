class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            } else {
                map.put(s1.charAt(i), 1);
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s2.charAt(i))) {
                map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            }
        }

        int left = 0;
        int right = s1.length() - 1;
        while (right < s2.length()) {

            boolean result = true;
            for (Character key : map.keySet()) {
                if (map.get(key) != 0) {
                    result = false;
                }
            }
            if (result == true) {
                return result;
            }
            if (map.containsKey(s2.charAt(left))) {
                map.put(s2.charAt(left), map.get(s2.charAt(left)) + 1);
            }
            left++;
            right++;
            if (right < s2.length()) {
                if (map.containsKey(s2.charAt(right))) {
                    map.put(s2.charAt(right), map.get(s2.charAt(right)) - 1);
                }
            }

        }
        return false;
    }
}
