class Solution {
    int min = Integer.MAX_VALUE;
    public int minDominoRotations(int[] tops, int[] bottoms) {
        

        for (int i = 1; i <= 6; i++) {
            helper(tops,bottoms,i);
            helper(bottoms,tops,i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void helper(int[] tops,int[] bottoms,int i) {
        boolean possible = true;
        int minCount = 0;
        int curr = i;
        for (int j = 0; j < tops.length; j++) {
            if (tops[j] != curr) {
                if (bottoms[j] == curr) {
                    minCount++;
                } else {

                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            min = Math.min(min, minCount);
        }
    }
}
