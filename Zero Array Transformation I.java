class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefix = new int[nums.length];
        Arrays.fill(prefix,0);
        for(int i=0;i<queries.length;i++){
            int[] curr = queries[i];
            prefix[curr[0]]++;
            if(curr[1] + 1  < nums.length){
                prefix[curr[1] + 1]--;
            }
        }
        //Adding up
        for(int i=1;i<nums.length;i++){
            prefix[i] += prefix[i - 1];
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] - prefix[i] > 0)return false;
        }
        return true;
    }
}
