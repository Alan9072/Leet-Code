class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int ptr1 = 0;
        int ptr2 = 0;
        int count = 0;

        while( ptr1 < str1.length() && ptr2 < str2.length()){
            char string1 = str1.charAt(ptr1);
            char string2 = str2.charAt(ptr2);
            if(string1 == string2 ||
             string1 == 'z' && string2 == 'a' ||
             string1 + 1 == string2){
                ptr2++;
                ptr1++;
                count++;
            }else{
                ptr1++;
            }
            
        }

        return count == str2.length();
    }
}
