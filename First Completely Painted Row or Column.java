class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int arrRow[] = new int[mat.length];
        int arrCol[] = new int[mat[0].length];

        Pair posArr[] = new Pair[arr.length + 1];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                posArr[mat[i][j]] = new Pair(i,j);
            }
        }

        for(int i=0;i<arr.length;i++){
            int currVal = arr[i];
            Pair curr = posArr[currVal];

            arrRow[curr.i]++;
            if(arrRow[curr.i] == mat[0].length)return i;

            arrCol[curr.j]++;
            if(arrCol[curr.j] == mat.length)return i;
        }
        return 0;
    }

}
