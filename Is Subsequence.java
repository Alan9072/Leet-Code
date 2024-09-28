class Solution {
    public boolean isSubsequence(String s, String t) {
        int count = 0;
        int left = 0;
        int right = t.length() - 1;
        
        for(int i=0;i<s.length();i++){
           
            while(left <= right){
                if(t.charAt(left)!=s.charAt(i)){
                    left++;
                }
                else{
                    count++;
                    left++;
                    break;
                }
            }
        }
    
        if(count == s.length())return true;
        return false;
    }
}
