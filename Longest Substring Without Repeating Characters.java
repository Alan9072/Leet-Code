class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)return 0;
        int longest = 0;
        int[] arr = new int[128];
        int left = 0;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]++;

            while(left < i && arr[s.charAt(i)] > 1){
                arr[s.charAt(left)]--;
                left++;
            }

            longest = Math.max(longest,i - left + 1);
        }
        return longest;
    }
}
