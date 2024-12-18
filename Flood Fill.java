class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image,sr,sc,color);
        return image;
    }
    public void fill(int[][] image,int sr,int sc,int color){
        int curr = image[sr][sc];
        if(curr == color)return;
        image[sr][sc] = color;
        
        if(sr > 0 && image[sr-1][sc] == curr)fill(image,sr-1,sc,color);
        if(sr < image.length-1 && image[sr+1][sc] == curr) fill(image,sr+1,sc,color);
        if(sc > 0 && image[sr][sc-1] == curr)fill(image,sr,sc-1,color);
        if(sc < image[0].length-1 && image[sr][sc+1] == curr) fill(image,sr,sc+1,color);
    }
}
