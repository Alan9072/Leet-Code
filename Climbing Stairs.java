class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }
        return climbs(n,arr);
        
    }
    public int climbs(int n,int arr[]) {
        if(n == 0)return 1;
        if(n < 0)return 0;
        if(arr[n] != -1)return arr[n];
        arr[n] = climbs(n - 1,arr) + climbs(n - 2,arr);
        return arr[n];
    }
}
