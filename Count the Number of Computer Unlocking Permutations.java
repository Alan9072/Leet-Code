class Solution {
    int MOD = 1000000000 + 7;
    public int countPermutations(int[] complexity) {
        int st = complexity[0];
        for(int i=1;i<complexity.length;i++){
            if(complexity[i] <= st)return 0;
        }

        return factorial(complexity.length - 1);
    }
    public int factorial(int val){
        if(val == 1)return 1;

        return (int)(((long)val * factorial(val - 1)) % MOD);
    }
}
