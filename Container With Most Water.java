class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length-1;
        while(left!=right){
            if(height[left]<height[right]){
                int newArea =  height[left]*(right-left);
                if(area < newArea){
                    area = newArea;
                }
                left++;
            }
            else{
                int newArea =  height[right]*(right-left);
                if(area < newArea){
                    area = newArea;
                }
                right--;
            }
        }
        return area;
    }
}
