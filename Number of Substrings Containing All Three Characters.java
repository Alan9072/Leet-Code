class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];

        int count =0;
        int left = 0;
        for(int right = 0;right < s.length();right++){

            char curr = s.charAt(right);
            if(curr == 'a' || curr == 'b' || curr == 'c'){
                arr[curr - 'a']++;
            }

            while( arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
                 count += s.length() - right;
                 arr[s.charAt(left) - 'a']--;
                 left++;
            }
        }
        return count;
    }
}
