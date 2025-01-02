class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] valid = new boolean[triplets.length];
        for(int i=0;i<triplets.length;i++){
            int flag = 0;
            for(int j=0;j<3;j++){
                if(triplets[i][j] > target[j]){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)valid[i] = true;
        }
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;
        for(int i=0;i<triplets.length;i++){
            if(valid[i] == true){
                if(triplets[i][0] == target[0])case1 = 1;
                if(triplets[i][1] == target[1])case2 = 1;
                if(triplets[i][2] == target[2])case3 = 1;
            }
        }

        return case1 + case2 + case3 == 3 ? true : false;
    }
}
