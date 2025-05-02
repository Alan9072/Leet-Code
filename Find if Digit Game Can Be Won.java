class Solution {
    public boolean canAliceWin(int[] nums) {
        int dble = 0;
        int single = 0;
        for(int val : nums){
            if(val < 10)single += val;
            else{
                dble += val;
            }
        }
        return single != dble;
    }
}
