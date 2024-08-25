class Solution {
    public int matrixSum(int[][] nums) {
        int sum = 0;
        int pos = 0;
        for(int i=0;i<nums.length;i++){
            Arrays.sort(nums[i]);
        }
        for(int k = 0;k<nums[0].length;k++){
            int highest = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i][pos] > highest) highest = nums[i][pos];
            }
            pos++;
            sum+=highest;

        }
        return sum;
    }
}
