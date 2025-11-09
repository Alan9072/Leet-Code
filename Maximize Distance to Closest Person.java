class Solution {
    public int maxDistToClosest(int[] seats) {
        int left[] = new int[seats.length];
        int right[] = new int[seats.length];

        int lp = -1;
        int rp = -1;
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 1){
                left[i] = i;
                lp = i;
            }else{
                left[i] = lp;
            }
        }
        for(int i=seats.length - 1;i>=0;i--){
            if(seats[i] == 1){
                right[i] = i;
                rp = i;
            }else{
                right[i] = rp;
            }
        }
        
        int maxD = 0;
        for(int i=0;i<seats.length;i++){
            if(seats[i] == 0){
                if(left[i] == -1){
                    maxD = Math.max(Math.abs(right[i] - i),maxD);
                }else if(right[i] == -1){
                    maxD = Math.max(Math.abs(left[i] - i),maxD);
                }else{
                    maxD = Math.max(maxD,Math.min(Math.abs(right[i] - i),Math.abs(left[i] - i)));
                }
            }
        }
        return maxD;
    }
}
