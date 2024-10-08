class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
 
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0)break;
            if(i > 0 && nums[i] == nums[i-1])continue;
            int left = i+1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if( (sum + nums[i]) < 0){
                    left++;
                }
                else if( sum + nums[i] > 0){
                    right--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                }
            }
        }
        
        return result;
    }
}
