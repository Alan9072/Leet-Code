class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int subStringLen = wordLen * wordCount;
        int strLen = s.length();

        HashMap<String, Integer> mainMap = new HashMap<>();
        for (String word : words) {
            mainMap.put(word, mainMap.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset, matchedWords = 0;
            HashMap<String, Integer> subMap = new HashMap<>();

            while (right + wordLen <= strLen) {
                String sub = s.substring(right, right + wordLen);
                right += wordLen;

                if (mainMap.containsKey(sub)) {
                    subMap.put(sub, subMap.getOrDefault(sub, 0) + 1);
                    matchedWords++;

                    while (subMap.get(sub) > mainMap.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        subMap.put(leftWord, subMap.get(leftWord) - 1);
                        left += wordLen;
                        matchedWords--;
                    }

                    if (matchedWords == wordCount) {
                        result.add(left);
                    }
                } else {
                    subMap.clear();
                    matchedWords = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
