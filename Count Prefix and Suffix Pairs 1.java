class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j]))count++;
            }
        }
        return count;
    }
        
    public boolean isPrefixAndSuffix(String str1,String str2){
        if(str2.length() == 0)return false;
        if(str1.length() > str2.length())return false;
        int str1Len = str1.length();
        if(str2.substring(0,str1Len).equals(str1) && str2.substring(str2.length() - str1Len).equals(str1)){
            return true;
        }else{
            return false;
        }
    }
}
