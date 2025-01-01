class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total1 = 0;
        int total2 = 0;
        for(int val : gas){
            total1 += val;
        }
        for(int val : cost){
            total2 += val;
        }
        if(total1 < total2)return -1;
        
        int mainTotal = 0;
        int start = 0;
        for(int i=0;i<gas.length;i++){
            mainTotal += gas[i] - cost[i];
            if(mainTotal < 0){
                mainTotal = 0;
                start = i + 1;
            }
        }
        
        return start;

    }
}
