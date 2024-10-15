class Solution {
    public long minimumSteps(String s) {
       long count = 0;
       int ones = 0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i) == '1'){
            ones++;
        }
        else{
            count+=ones;
        }
       }
       return count;
    }
}
