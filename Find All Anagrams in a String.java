class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> list = new ArrayList<>();

        if(p.length() > s.length())return list;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int start = 0;
        int end = 0;
        while (end != p.length()) {
            map1.put(p.charAt(end), map1.getOrDefault(p.charAt(end), 0) + 1);
            end++;
        }

        int left = 0;
        int right = 0;
        while (right < p.length()) {
            map2.put(s.charAt(right), map2.getOrDefault(s.charAt(right), 0) + 1);
            right++;
        }

        right = p.length() - 1;

        while (right < s.length()) {
            if (map2.equals(map1)) {
                list.add(left);
            }
            char leftChar = s.charAt(left);
            map2.put(leftChar, map2.getOrDefault(leftChar,0) - 1);
            if (map2.get(leftChar) == 0) {
                map2.remove(leftChar);
            }

            left++;
            right++;
            
            if (right < s.length()) {
                char rightChar = s.charAt(right);
                map2.put(rightChar, map2.getOrDefault(rightChar, 0) + 1);
            }

        }
        return list;
    }
}
