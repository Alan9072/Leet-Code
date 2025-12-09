class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1000000000 + 7;
        Map<Integer,Integer> freqPrev = new HashMap<>();
        Map<Integer,Integer> freqNext = new HashMap<>();

        int count = 0;
        for(int i=1;i<nums.length;i++){
            freqNext.put(nums[i],freqNext.getOrDefault(nums[i],0) + 1);
        }

        for(int i=1;i<nums.length;i++){
            freqPrev.put(nums[i-1],freqPrev.getOrDefault(nums[i-1],0)+1);
            freqNext.put(nums[i],freqNext.get(nums[i]) - 1);

            if(freqNext.get(nums[i]) == 0){
                freqNext.remove(nums[i]);
            }

            if(freqPrev.containsKey(nums[i] * 2) && freqNext.containsKey(nums[i] * 2)){
                count = (int)(count + ((long)freqPrev.get(nums[i] * 2) * freqNext.get(nums[i] * 2)) % MOD ) % MOD;
            }

        }
        return count;
    }
}
