class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length - 1;
        int left = 1;
        int right = position[n];

        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(possible(mid,position,m)){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public boolean possible(int val,int[] position,int m){
        int nxt = -1;
        for(int i=0;i<position.length;i++){
            if(nxt == -1 || position[i] >= nxt){
                nxt = position[i] + val;
                m--;
            }
            if(m == 0)return true;

        }
        return false;
    }
}
