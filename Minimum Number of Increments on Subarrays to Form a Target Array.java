class Solution {
    public int minNumberOperations(int[] target) {
        int sum = 0;
        sum += target[target.length - 1];
        for(int i=1;i<target.length;i++){
            if(target[i-1] > target[i]){
                sum += target[i-1] - target[i];
            }
        }
        return sum;
    }
}
