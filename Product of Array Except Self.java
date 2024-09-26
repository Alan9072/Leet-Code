class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();

        int result[] = new int[nums.length];
        
        left.put(0,1);
        for(int i=1;i<nums.length;i++){
            left.put(i,left.getOrDefault(i-1,1)*nums[i-1]);
        }
        right.put(nums.length-1,1);
        for(int i=nums.length-2;i>=0;i--){
            right.put(i,right.getOrDefault(i+1,1)*nums[i+1]);
        }
        
        for(int i=0;i<nums.length;i++){
            result[i] = left.get(i) * right.get(i);
        }
        return result;
    }
}
