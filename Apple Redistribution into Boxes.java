class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int val : apple){
            sum += val;
        }
        Arrays.sort(capacity);

        int count = 0;
        for(int i=capacity.length - 1;i>=0;i--){
            sum -= capacity[i];
            count++;
            if(sum == 0 || sum < 0)return count;
        }
        
        return count;
    }
}
