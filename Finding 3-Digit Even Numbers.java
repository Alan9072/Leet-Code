class Solution {
    public int[] findEvenNumbers(int[] digits) {

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i] == 0)continue;
            for(int j=0;j<digits.length;j++){
                if(i == j)continue;
                for(int k=0;k<digits.length;k++){
                    if(j == k)continue;
                    if(i == k)continue;
                    int number = Integer.parseInt(digits[i] + ""+ digits[j] + ""+ digits[k]);

                    if(number % 2 == 0){
                        set.add(number);
                    }
                }
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for(int val : set){
            result[index] = val;
            index++;
        }
        Arrays.sort(result);
        return result;
    }
}
