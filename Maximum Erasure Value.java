class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = 0;

        int left = 0;
        for(int i=0;i<nums.length;i++){

            while(set.contains(nums[i])){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            sum += nums[i];
            max = Math.max(sum,max);
            set.add(nums[i]);

        }
        return max;
    }
}
