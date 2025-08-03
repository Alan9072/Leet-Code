class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int max = 0;

        for(int val : houses){
            max = Math.max(findClose(val,heaters),max);
        }
        return max;

    }
    public int findClose(int val,int[] heaters){
        int left = 0;
        int right = heaters.length - 1;

        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right - left)/2;
            min = Math.min(min,Math.abs(heaters[mid] - val));

            if(heaters[mid] == val)return 0;
            else if(val < heaters[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return min;
    }
}
