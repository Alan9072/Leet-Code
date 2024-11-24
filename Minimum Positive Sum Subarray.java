class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int sum = 0;
            int j = 0;
            int left = 0;
            for( j=0;j<i;j++){
                sum+=nums.get(j);
            }
            if(sum > 0){
                     min = Math.min(sum,min);
                }
            while(j < nums.size()){
                
                sum+= nums.get(j);
                sum-= nums.get(left);
                if(sum > 0){
                     min = Math.min(sum,min);
                }
                left++;
                j++;
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
}
