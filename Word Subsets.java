class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(int i=0;i<words2.length;i++){
            int arr[] = new int[26];
            for(int j=0;j<words2[i].length();j++){
                char curr = words2[i].charAt(j);
                arr[curr - 'a']++;
            }
            for(int j=0;j<26;j++){
                if(arr[j] != 0){
                    if(!freqMap.containsKey((char)('a' + j))){
                        freqMap.put((char)('a'+ j),arr[j]);
                    }else{
                        freqMap.put((char)('a'+ j),Math.max(arr[j],freqMap.get((char)('a'+ j))));
                    }
                }
            }
        }
        
        for(int i=0;i<words1.length;i++){
            int[] arr = new int[26];
            for(int j=0;j<words1[i].length();j++){
                char curr = words1[i].charAt(j);
                arr[curr - 'a']++;
            }
            int flag = 0;
            for(int j=0;j<26;j++){    
                if(freqMap.containsKey((char)('a'+ j))){
                    if(arr[j] < freqMap.get((char)('a' + j))){
                        flag = 1;
                        break;
                    }
                }
            }
            if(flag == 0)result.add(words1[i]);
            
        }


        return result;
    }
}
