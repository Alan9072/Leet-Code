class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
            if(n == 0)break;
            if(flowerbed[i] == 0){
                boolean case1 = false;
                boolean case2 = false;
                if(i-1 < 0 || ( i - 1 >= 0 && flowerbed[i-1] == 0)){
                    case1 = true;
                }
                if(i+1 == flowerbed.length || (i + 1 < flowerbed.length && flowerbed[i+1] == 0)){
                    case2 = true;
                }
                if(case1 && case2){
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n==0;
    }
}
