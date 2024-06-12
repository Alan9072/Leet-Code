class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            int length1 = 0;int length2 = 0;int length3 = 0;
            for(int j=0;j<word.length();j++){
                char a = Character.toLowerCase(word.charAt(j));
                if("qwertyuiop".contains(a+""))length1++;
                if("asdfghjkl".contains(a+""))length2++;
                if("zxcvbnm".contains(a+""))length3++;
                
            }
            if(length1 == word.length()||length2 == word.length()||length3 == word.length()){
                list.add(word);
            }
        }
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
        return arr;
    }
}
