class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        //upto k
        int countK = 0;

        int left = 0;
        for(int right = 0;right < nums.length;right++){
            
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);

            while(map.size() > k){
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            countK += right - left + 1;
        }
        // upto k - 1
        int countKminus1 = 0;
        map.clear();
        left = 0;
        for(int right = 0;right < nums.length;right++){
            
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);

            while(map.size() > k - 1){
                map.put(nums[left],map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            countKminus1 += right - left + 1;
        }

        return countK - countKminus1;
    }
}
