class Solution {
    public long flowerGame(int n, int m) {
        long count = 0;

        for(int i=1;i<=n;i++){
            if(i%2 == 0){
                int rem = m % 2;
                count += (m / 2) + rem;
            }else{
                count += (m / 2);
            }
        }
        return count;
    }
}
