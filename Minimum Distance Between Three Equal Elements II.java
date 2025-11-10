class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minV = Integer.MAX_VALUE;
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            if(list.size() >= 3){
                for(int n=0;n<=list.size() - 3;n++){
                    int i = list.get(n);
                    int j = list.get(n+1);
                    int k = list.get(n+2);
                    minV = Math.min(minV,Math.abs(i-j) + Math.abs(j-k) + Math.abs(i-k));
                }
            }
        }
        return minV == Integer.MAX_VALUE ? -1 : minV;
    }
}
