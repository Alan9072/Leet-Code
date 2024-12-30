class Solution {
    public int rob(int[] nums) {
        
        int[] helper = new int[nums.length];
        for(int i=0;i<helper.length;i++){
            helper[i] = -1;
        }
        return robed(nums,helper,nums.length - 1);
    }
    public int robed(int[] nums,int[] helper,int index){
        if(index == 0){
            return nums[index];
        }
        if(index < 0)return 0;
        if(helper[index] != -1)return helper[index];

        int case1 = nums[index] + robed(nums,helper,index - 2);
        int case2 = robed(nums,helper,index - 1);
        helper[index] = Math.max(case1,case2);

        return Math.max(case1,case2);
    }
}
