class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> count = new HashSet<>();
       
        for(int i=0;i<nums.length;i++){
            count.add(nums[i]);
            int newNum = 0;
            while(nums[i]>0){
                int rem = nums[i]%10;
                newNum = newNum * 10 + rem;
                nums[i] = nums[i]/10;
            }
            count.add(newNum);
        }
        return count.size();
        
    }
}
