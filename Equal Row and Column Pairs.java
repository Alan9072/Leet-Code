class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){

            for(int k=0;k<grid[i].length;k++){
                int pos = 0;
                int arr[] = new int[grid[i].length];
                    for(int j=0;j<grid[i].length;j++){
                    arr[pos] =  grid[j][k];
                    pos++;
                }
                if(Arrays.equals(grid[i],arr)){
                    count++;
                }
            }
            
        }
        return count;
    }
}
