class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i=0;i<=nums.size() - 2*k;i++){
            boolean valid1 = true;
            boolean valid2 = true;
            for(int j=i+1;j<i+k;j++){
                if(nums.get(j) <= nums.get(j - 1)){
                    valid1 = false;
                    break;
                }
            }
            for(int j=i+k+1;j<i+2*k;j++){
                if(nums.get(j) <= nums.get(j - 1)){
                    valid2 = false;
                    break;
                }
            }
            if(valid1 && valid2)return true;   
        }
        return false;
    } 
}
