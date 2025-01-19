class Solution {
    public int trap(int[] height) {
        int total = 0;
        int[] sum = new int[height.length];


        sum[height.length - 1] = height[height.length - 1];
        for(int i=height.length - 2;i>=0;i--){
            sum[i] = Math.max(height[i],sum[i + 1]);
        }

        for(int i=0;i<height.length - 1;i++){
            if(i == 0){
                sum[i] = height[i];
            }else{

                int leftMax = sum[i - 1];
                int rightMax = sum[i + 1];
                if(height[i] < leftMax && height[i] < rightMax){
                    total += Math.min(leftMax,rightMax) - height[i];
                }
                sum[i] = Math.max(sum[i - 1],height[i]);
            }
            
        }
        return total;
    }
}
