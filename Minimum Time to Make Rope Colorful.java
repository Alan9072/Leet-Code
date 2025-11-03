class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minT = 0;
        int last = 0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i) == colors.charAt(last)){
                if(neededTime[last] < neededTime[i]){
                    minT += neededTime[last];
                }else{
                    minT += neededTime[i];
                    neededTime[i] = neededTime[last];
                }
            }
            last++;
        }
        return minT;
    }
}
