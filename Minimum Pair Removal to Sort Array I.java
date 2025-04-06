class Solution {
    public int minimumPairRemoval(int[] nums) {
         List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        if(isSorted(list))return 0;

        int count = 0;
        while(isSorted(list) == false){
            int minA = -1;
            int minB = -1;
            int sum = Integer.MAX_VALUE;
            for(int i=1;i<list.size();i++){
                if(minA == -1 && minB == -1){
                    minA = i - 1;
                    minB = i;
                }
                if(sum > list.get(i) + list.get(i - 1)){
                    sum = list.get(i) + list.get(i - 1);
                    minA = i - 1;
                    minB = i;
                }
            }
            list.remove(minB);
            list.set(minA,sum);
            count++;
        }
        return count;
        
    }
    public boolean isSorted(List<Integer> list) {
    for (int i = 1; i < list.size(); i++) {
        if (list.get(i) < list.get(i - 1)) {
            return false;
        }
    }
    return true;
}
}©leetcode
