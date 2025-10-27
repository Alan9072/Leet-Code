class Solution {
    public int numberOfBeams(String[] bank) {
        int laser = 0;
        int prev = 0;
        int curr = 0;
        for(int i=0;i<bank.length;i++){
            String row = bank[i];
            int cnt = 0;
            for(int j=0;j<row.length();j++){
                if(row.charAt(j) == '1'){
                    cnt++;
                }
            }
            if(prev == 0 && cnt > 0){
                prev = cnt;
            }else if( curr == 0 && cnt > 0){
                curr = cnt;
                laser += prev * cnt;
                prev = curr;
                curr = 0;
            }
        }
        return laser;
    }
}
