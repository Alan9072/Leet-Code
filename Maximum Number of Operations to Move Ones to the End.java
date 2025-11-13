class Solution {
    public int maxOperations(String s) {
        char[] arr = s.toCharArray();
        int ops = 0;
        int oneC = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '1')oneC++;
            else{
                while(i+1 < arr.length && arr[i+1] == '0'){
                    i++;
                }
                ops += oneC;
            }
        }
        return ops;
    }
}
