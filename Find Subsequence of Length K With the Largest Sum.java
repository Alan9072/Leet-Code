class Pair{
    int val;
    int index;
    Pair(int val,int index){
        this.val = val;
        this.index = index;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Pair[] arr = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr,(a,b)->{
            return a.val - b.val;
        });
        Pair[] res = new Pair[k];
        int arrst = arr.length - k;

        int index = 0;
        for(int i=arrst;i<nums.length;i++){
            res[index] = arr[i];
            index++;
        }

        Arrays.sort(res,(a,b)->{
            return a.index - b.index;
        });

        int[] result = new int[k];
        for(int i=0;i<result.length;i++){
            result[i] = res[i].val;
        }
        return result;
    }
}
