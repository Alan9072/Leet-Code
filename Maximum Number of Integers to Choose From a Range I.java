class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int val : banned){
            set.add(val);
        }
        int count = 0;
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(i + sum <= maxSum && !set.contains(i)){
                count++;
                sum += i;
            }
        }
        return count;
    }
}
