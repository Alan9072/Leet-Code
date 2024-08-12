class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int array[] = new int[2*length];
        int i;
        for(i=0;i<nums.length;i++){
            array[i] = nums[i];
        }
        int j = 0;
        for(i = length;i<array.length;i++){
            array[i] = nums[j];
            j++;
        }
        return array;
        
    }
}
