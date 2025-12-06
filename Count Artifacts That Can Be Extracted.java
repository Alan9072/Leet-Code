class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean [][]digVal = new boolean[n][n];

        for(int[] arr : dig){
            digVal[arr[0]][arr[1]] = true;
        }
        int count = 0;

        for(int i=0;i<artifacts.length;i++){
            int[] curr = artifacts[i];
            boolean valid = true;

            for(int j=curr[0];j<=curr[2];j++){
                for(int k=curr[1];k<=curr[3];k++){
                    if(digVal[j][k] == false)valid = false;
                }
            }

            if(valid)count++;
        }

        return count;
    }
}
