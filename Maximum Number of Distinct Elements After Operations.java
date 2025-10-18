class Solution {
    int lim;
    public int maxDistinctElements(int[] nums, int k) {
        lim = k;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){

            int curr = nums[i];
            int val = findVal(curr,set);
            if( val != Integer.MAX_VALUE){
                set.add(curr + val);
            }
        }
        return set.size();

    }
    public int findVal(int val,HashSet<Integer> set){

        int left = - lim;
        int right = lim;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(!set.contains(val + mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left > lim)return Integer.MAX_VALUE;
        else{
            return left;
        }
    }
}
