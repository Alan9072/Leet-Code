class Solution {
    public String smallestPalindrome(String s) {
        char arr[] = new char[s.length() / 2];
        for(int i=0;i<s.length() / 2;i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        
        for(char ch : arr){
            sb.append(ch);
        }

        StringBuilder rev = new StringBuilder(sb);
        
        rev.reverse();
        
        if(s.length() % 2 != 0){
            int index = s.length() / 2;
            sb.append(s.charAt(index));
        }

        sb.append(rev.toString());
        return sb.toString();
    }
}
