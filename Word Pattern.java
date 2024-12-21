class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String arr[] = s.split(" ");
        if (pattern.length() != arr.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            String word = arr[i];
            char curr = pattern.charAt(i);
            if (!map.containsKey(curr) && !map.values().contains(word)) {
                map.put(curr, word);
            } else if (map.containsKey(curr) && !map.get(curr).equals(word))
                return false;
            else if (!map.containsKey(curr) && map.values().contains(word))
                return false;

        }
        return true;
    }
}
