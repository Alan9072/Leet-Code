class Solution {
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] valid = new int[n];
        dfs(0,requests,valid,0);
        return max;
    }
    public void dfs(int idx,int[][] requests,int[] valid,int accepted){
        if(idx >= requests.length){
            for(int val : valid){
                if(val != 0)return;
            }
            max = Math.max(max,accepted);
            return;
        }
        
        //take
        int out = requests[idx][0];
        int in = requests[idx][1];
        valid[out]--;
        valid[in]++;
        dfs(idx+1,requests,valid,accepted + 1);
        valid[out]++;
        valid[in]--;

        //notTake
        dfs(idx+1,requests,valid,accepted);
    }
}
