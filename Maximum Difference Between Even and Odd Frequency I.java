class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            arr[curr - 'a']++;
        }
        int maxodd = 0;
        int mineven = s.length();
        for(int val : arr){
            if(val == 0)continue;
            if(val % 2 == 0){
                mineven = Math.min(mineven,val);
            }else{
                maxodd = Math.max(maxodd,val);
            }
        }
        return (maxodd - mineven);
    }
}
