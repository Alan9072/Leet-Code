class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;

        int[] mainArr = new int[26];
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            
            if(mainArr[curr - 'a'] == 0){
                int subArr[] = new int[26];
                int lastIndex = s.lastIndexOf(curr);
                for(int j=i+1;j<lastIndex;j++){
                    char current = s.charAt(j);
                    if(subArr[current - 'a'] == 0){
                        count++;
                        subArr[current - 'a'] = 1;
                    }
                }
                mainArr[curr - 'a'] = 1;;
            }
            
        }
        return count;
    }
}
