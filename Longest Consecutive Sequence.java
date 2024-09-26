class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for( int num :nums){
            set.add(num);
        }
        
        int greatest = 0;
        for( int val : set){
            if(set.contains(val - 1))continue;
            int count = 0;
            int i=1;
            count++;
            while(set.contains(val+i)){
                count++;
                i++;
            }
            if(count > greatest){
                greatest = count;
            }
        }
    return greatest;
    }
}
