class Solution {
    public int findNumbers(int[] nums) {
        int even = 0;
        for(int val : nums){
            String value = String.valueOf(val);
            if(value.length() % 2 == 0)even++;;
        }
        return even;
    }
}
