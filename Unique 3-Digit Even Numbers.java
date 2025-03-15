class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                if(i == j)continue;
                for(int k = 0;k<digits.length;k++){
                    if(i == k || j == k)continue;
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if(num % 2 == 0 && String.valueOf(num).length() == 3)set.add(num);
                }
            }
        }
        return set.size();
    }
}©leetcode
