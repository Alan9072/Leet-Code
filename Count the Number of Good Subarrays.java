class Solution {
    public long countGood(int[] nums, int k) {

        long goodArrays = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;

        for(int right = 0;right < nums.length;right++){
            int currCount = map.containsKey(nums[right]) ? map.get(nums[right]) : 0;
            map.put(nums[right],map.getOrDefault(nums[right],0) + 1);
            
            if(map.get(nums[right]) == 2){
                count++;
            }else if(map.get(nums[right]) > 2){
                count += currCount;
            }

            if(count >= k){
                goodArrays += (long) (nums.length - right);
            }

            while(count >= k){
                map.put(nums[left],map.getOrDefault(nums[left],0) - 1);
                if(map.get(nums[left]) <= 0){
                    map.remove(nums[left]);
                }else{
                    count -= map.get(nums[left]);
                }
                left++;
                if(count >= k){
                    goodArrays += (long) (nums.length - right);
                }

            }
        }

        return goodArrays;
    }
}
