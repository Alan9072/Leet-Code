class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if(curr.equals("#"))continue;

            int[] arr1 = new int[26];
            for (int n=0;n<curr.length();n++) {
                arr1[curr.charAt(n) - 'a']++;
            }

            for (int j = i + 1; j < words.length; j++) {
                String sub = words[j];
                int[] arr2 = new int[26];
                for (int m=0;m<sub.length();m++) {
                    arr2[sub.charAt(m) - 'a']++;
                }

                int valid = 1;
                for(int k=0;k<26;k++){
                    if(arr1[k] != arr2[k]){
                        valid = 0;
                    }
                }

                if(valid==1){
                    words[j] = "#";
                }else{
                    break;
                }

            }
            result.add(words[i]);
        }
        return result;
    }
}
