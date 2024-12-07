class Solution {
    public int minOperations(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k)
                return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums){
            if(val != k){
                map.put(val,map.getOrDefault(val,0)+1);
            }
            
        }
        return map.size(); 

    }
}
