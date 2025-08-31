class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] wordScore = new int[words.length];

        for(int i=0;i<words.length;i++){
            String curr = words[i];
            int val = 0;

            for(int j=0;j<curr.length();j++){
                val += score[curr.charAt(j) - 'a'];
            }
            wordScore[i] = val;
        }

        int[] map = new int[26];
        for(char ch : letters){
            map[ch - 'a']++;
        }

        return dfs(0,words,map,wordScore);
    }
    public int dfs(int idx,String[] words,int[] map,int[] wordScore){
        if(idx >= words.length)return 0;

        int valid = 1;
        String curr = words[idx];

        for(int i=0;i<curr.length();i++){
            if(map[curr.charAt(i) - 'a'] == 0){
                valid = 0;
            }
            map[curr.charAt(i) - 'a']--;
        }

        int take = 0;
        if(valid == 1){
            take = wordScore[idx] + dfs(idx + 1,words,map,wordScore);
        }

        for(int i=0;i<curr.length();i++){
            map[curr.charAt(i) - 'a']++;
        }
        int notTake = dfs(idx + 1,words,map,wordScore);

        return Math.max(take,notTake);
    }
}
