class Pair{
    int old;
    int val;
    int idx;
    Pair(int old,int val,int idx){
        this.old = old;
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Pair[] sub = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            sub[i] = new Pair(nums[i],calculate(nums[i],mapping),i);
        }

        Arrays.sort(sub,(a,b)->{
            return a.val == b.val ? a.idx - b.idx : a.val - b.val;
        });
        
        for(int i=0;i<nums.length;i++){
            nums[i] = sub[i].old;
        }
        return nums;
    }
    public int calculate(int val,int[] mapping){
        if (val == 0) return mapping[0];
        int result = 0;
        int multiplier = 1;
        while(val > 0){
            int rem = val % 10;
            result = mapping[rem] * multiplier + result;
            multiplier *= 10;
            val = val / 10;
        }
        return result;
    }
}
