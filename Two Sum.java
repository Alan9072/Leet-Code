class Solution {
     int val,val2;
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[2];
        int pos = 0;
       
        for(int i=0;i<nums.length;i++){
            val = nums[i];
            val2 = target - val;
            if(!set.contains(val2)){
                set.add(val);
            }
            else{
                break;
            }
        }
        for(int i=0;i<nums.length;i++){

            if(nums[i] == val || nums[i] == val2){
                arr[pos] = i;
                pos++;
            }
        }
        return arr;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        for (int i = 0; i < nums.length; i++) 
        {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                   
                    return new int[]{i,j};
                    
                    
                }
            }
        }
        
    return new int[]{};
    }
}
