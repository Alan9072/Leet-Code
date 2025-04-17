class Solution {
    String result;
    int count;
    public String getPermutation(int n, int k) {
        int total = factorial(n);
        int parted = total / n;
        int start = ((k - 1) / parted) + 1;

        boolean visited[] = new boolean[n+1];
        visited[start] = true;
        StringBuilder sb = new StringBuilder(""+ start);
        count = parted * (start - 1);
        dfs(n,k,sb,visited);
        return result;
    
    }
    public boolean dfs(int n,int k,StringBuilder sb,boolean[] visited){
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
                return true;
            }
        }

        for(int i=1;i<=n;i++){
            if(visited[i] == false){
                visited[i] = true;
                sb.append(""+i);
                if(dfs(n,k,sb,visited)){
                    return true;
                }
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
        return false;
    }
    public int factorial(int val){
        int fact = 1;
        for(int i=1;i<=val;i++){
            fact *= i;
        }
        return fact;
    }
}
