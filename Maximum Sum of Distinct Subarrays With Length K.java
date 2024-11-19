class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long mainSum = 0;
   
        int right = 0;
        int left = 0;
        for ( right = 0; right < k; right++) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
        }

        for (int i = right; i <= nums.length; i++) {
            if (sum > mainSum && map.size() == k) {
                mainSum = sum;
            }
            if(i == nums.length) break;// to break the loop at i = nums.length after checking the sum
            map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
            if(map.get(nums[left]) == 0){
                map.remove(nums[left]);
            }
            sum -= nums[left];
            left++;

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];

        }
        return (long) mainSum;

    }
}
