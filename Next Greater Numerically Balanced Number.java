class Solution {
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;i<=10000000;i++){
            int val = i;
            if(isValid(val))return val;
        }
        return -1;
    }
    public boolean isValid(int val){
        int[] arr = new int[10];
        while(val > 0){
            int rem = val % 10;
            arr[rem]++;
            val = val / 10;
        }
        boolean valid = true;
        for(int i=0;i<10;i++){
            if(arr[i] > 0 && arr[i] != i){
                valid = false;
                break;
            }
        }
        return valid;
    }
}
