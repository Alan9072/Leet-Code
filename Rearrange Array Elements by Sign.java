class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length/2]; 
        int[] neg = new int[nums.length/2]; 
        int p=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                pos[p] = nums[i];
                p++;
            }
            else{
                neg[n] = nums[i];
                n++;
            }
        }
        p=0;
        n=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i] = pos[p];
                p++;
                }
            else{
                nums[i] = neg[n];
                n++;
            }
        }
        return nums;
    }
}
