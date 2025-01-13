class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[26];
        int count = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            arr[curr - 'a']++;
        }
        for(int val : arr){
            if(val != 0){
                if(val % 2 == 0){
                    count += 2;
                }else{
                    count += 1;
                }
            }
        }
        return count;
    }
}
