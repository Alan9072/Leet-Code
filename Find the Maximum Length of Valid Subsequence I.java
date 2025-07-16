class Solution {
    public int maximumLength(int[] nums) {
        int odds = 0;
        int evens = 0;
        int oddeven = 1;

        for(int val : nums){
            if(val % 2 == 0){
                evens++;
            }else{
                odds++;
            }
        }

        int val = 1;
        if(nums[0] % 2 == 0){
            val = 0;
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i] % 2 != val){
                oddeven++;
                val = nums[i] % 2;
            }
        }

        return Math.max(odds,Math.max(evens,oddeven));
    }
}
