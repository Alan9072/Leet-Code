class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] index = new int[26];
        Arrays.fill(index,-1);

        for(int i=0;i<s.length();i++){  
            char curr = s.charAt(i);
            if(index[curr - 'a'] != -1)continue;
            index[curr - 'a'] = s.lastIndexOf(curr);
        }

        int start = 0;
        while (start < s.length()) {
            int character = s.charAt(start);
            int subStart = start;
            while (start != index[character - 'a']) {
                char curr = s.charAt(start);
                if (index[curr - 'a'] > index[character - 'a']) {
                    character = curr;
                }
                start++;
            }
            list.add(start - subStart + 1);
            start++;
        }
        return list;
    }
}
