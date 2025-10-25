class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int cnt = 1;
        int val = 1;
        int prev = 1;
        while(cnt <= n){
            total += val;
            if(cnt % 7 == 0){
                val = prev + 1;
                prev = val;
            }else{
                val++;
            }
            cnt++;
        }
        return total;
    }
}
