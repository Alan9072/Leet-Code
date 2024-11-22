class Solution {
    int atlantic;
    int pacific;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
               
                atlantic = 0;
                pacific = 0;
                reach(heights, i, j);
                if (atlantic == 1 && pacific == 1) {
                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(i);
                    innerList.add(j);
                    mainList.add(innerList);

                }

            }
        }
        return mainList;
    }

    public void reach(int[][] heights, int i, int j) {

        int val = heights[i][j];
        heights[i][j] = -1;

        if (i == 0 || j == 0)
            pacific = 1;
        if (i == heights.length - 1 || j == heights[0].length - 1)
            atlantic = 1;

        if (pacific == 1 && atlantic == 1) {
            heights[i][j] = val;
            return;
        }
        
        if (i > 0 && heights[i - 1][j] <= val && heights[i - 1][j] != -1) {
            reach(heights, i - 1, j);
        }
        if (i < heights.length - 1 && heights[i + 1][j] <= val && heights[i + 1][j] != -1) {
            reach(heights, i + 1, j);
        }
        if (j > 0 && heights[i][j - 1] <= val && heights[i][j - 1] != -1) {
            reach(heights, i, j - 1);
        }
        if (j < heights[0].length - 1 && heights[i][j + 1] <= val && heights[i][j + 1] != -1) {
            reach(heights, i, j + 1);
        }

        heights[i][j] = val;
        

    }
}
