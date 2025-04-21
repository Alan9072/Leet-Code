class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int[] dummy = new int[differences.length + 1];
        int count = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int i=0;i<dummy.length;i++){
            if(i == 0){
                dummy[i] = lower;
                
            }else{
                dummy[i] = dummy[i - 1] + differences[i - 1];
            }
            low = Math.min(low,dummy[i]);
            high = Math.max(high,dummy[i]);
        }
        //make valid
        int val = lower - low;
        low += val;
        high += val;
        if(low >= lower && low <= upper && high <= upper && high >= lower){
            count++;
            count += (upper - high);
        }
        return count;
    }
}
/////////////////////////////////OPtimized one//////////////////////////////////
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0, currentPrefix = 0;

        for (int diff : differences) {
            currentPrefix += diff;
            minPrefix = Math.min(minPrefix, currentPrefix);
            maxPrefix = Math.max(maxPrefix, currentPrefix);
        }
        
        long lowX = lower - minPrefix;
        long highX = upper - maxPrefix;

        return highX < lowX ? 0 : (int) (highX - lowX + 1);
    }
}
