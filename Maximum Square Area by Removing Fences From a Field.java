class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1000000000 + 7;
        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];
        H[0] = 1;
        V[0] = 1;
        H[H.length - 1] = m;
        V[V.length - 1] = n;

        for(int i=1;i<H.length - 1;i++){
            H[i] = hFences[i-1];
        }
        for(int i=1;i<V.length - 1;i++){
            V[i] = vFences[i-1];
        }
        Arrays.sort(H);
        Arrays.sort(V);
        long result = 0;
        Set<Integer> hset = new HashSet<>();
        for(int i=0;i<H.length;i++){
            for(int j=i+1;j<H.length;j++){
                hset.add(H[j] - H[i]);
            }
        }

        for(int i=0;i<V.length;i++){
            for(int j=i+1;j<V.length;j++){
                int dist = (V[j] - V[i]);
                if(hset.contains(dist)){
                    if(dist > result){
                        result = dist;
                    }
                }
            }
        }
        return result == 0 ? -1 : (int)(result * result % MOD);


    }
}
