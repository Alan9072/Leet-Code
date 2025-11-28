class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefix[] = new long[nums.length];
        prefix[0] = nums[0];

        for(int i=1;i<prefix.length;i++){
            prefix[i] = nums[i] + prefix[i - 1];
        }

        HashMap<Integer,List<Long>> map = new HashMap<>();

        for(int i=0;i<=nums.length - k;i++){
            map.putIfAbsent(i % k,new ArrayList<>());
            long val = prefix[i+k-1] - (i == 0 ? 0 : prefix[i-1]);
            map.get(i%k).add(val);
        }

        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        for(int key : map.keySet()){
            List<Long> list = map.get(key);
            sum = 0;
            for(long val : list){
                sum += val;
                if(sum > maxSum){
                    maxSum = sum;
                }
                if(sum < 0)sum = 0;
            }
        }
        return maxSum;
    }
}
