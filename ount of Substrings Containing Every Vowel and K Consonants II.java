class Solution {
    public long countOfSubstrings(String word, int k) {
       return count(word,k) - count(word,k+1);
    }
    public long count(String word,int k){
         HashMap<Character, Integer> map = new HashMap<>();
        long count = 0;
        int consonents = 0;

        int left = 0;
        for (int right = 0; right < word.length(); right++) {
            char curr = word.charAt(right);

            if (curr != 'a' && curr != 'e' && curr != 'i' && curr != 'o' && curr != 'u') {
                consonents++;
            } else {
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }

            

            while (consonents >= k && map.size() == 5) {
                count += word.length() - right;
                char lcurr = word.charAt(left);
                if (lcurr != 'a' && lcurr != 'e' && lcurr != 'i' && lcurr != 'o' && lcurr != 'u') {
                    consonents--;
                } else {
                    map.put(lcurr, map.get(lcurr) - 1);
                    if(map.get(lcurr) == 0){
                        map.remove(lcurr);
                    }
                }
                left++;
            }


        }
        return count;
    }
}
