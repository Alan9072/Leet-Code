class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length/3][3];
        Arrays.sort(nums);

        int index = 0;
        for(int i=0;i<nums.length;i+=3){
            int curr = nums[i];
            
            int a = nums[i + 1];
            int b = nums[i + 2];

            if(a - curr <= k && b - curr <= k && b - a <= k){
                result[index][0] = curr;
                result[index][1] = a;
                result[index][2] = b;
            }else{
                return new int[0][];
            }
            index++;
        }
        return result;
    }
}
