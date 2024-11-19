class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int result[] = new int[2];
        int size = grid.length * grid.length;
        int sum = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(set.contains(grid[i][j]))result[0] = grid[i][j];
                set.add(grid[i][j]);
                sum += grid[i][j];
            }
        }
        System.out.println(sum);
        int realS = size * (size + 1)/2;
        System.out.println(realS);
        result[1] = realS - sum + result[0];

        return result;
    }
}
