class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(!set.contains(curr)){
                set.add(curr);
            }else{
                count++;
                set.clear();
                set.add(curr);
            }
        }
        return count;
    }
}
