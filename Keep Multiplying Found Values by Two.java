class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        while(true){
            if(set.contains(original)){
                original *= 2;
            }else{
                return original;
            }
        }
    }
}
