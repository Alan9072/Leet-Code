class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int length = s.length();
        int validness = -1;

        if (t.length() > s.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int count = 0;
        int limit = t.length();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            if (map.containsKey(curr)){
                if(map.get(curr) > 0) count++;
                map.put(curr, map.getOrDefault(curr,0) - 1);
            }
            
            while (count == limit) {
                validness = 0;
                int newLength = right - left + 1;
                if (newLength < length) {
                    start = left;
                    length = newLength;
                }
                
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar) && map.get(leftChar) < 0) {
                    map.put(leftChar, map.get(leftChar) + 1);
                }else if(map.containsKey(leftChar) && map.get(leftChar) == 0){
                    map.put(leftChar, map.get(leftChar) + 1);
                    count--;
                }
                left++;
            }
        }
        if(validness == -1)return "";
        return s.substring(start, start + length);

    }
}
