class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int area = 0;
        for(int i=0;i<dimensions.length;i++){
            int len = dimensions[i][0];
            int width = dimensions[i][1];
            double dia = Math.sqrt(len * len + width * width);

            if(dia > max){
                max = dia;
                area = len * width;
            }else if(dia == max){
                area = Math.max(area,len * width);
            }
        }
        return area;
    }
}
