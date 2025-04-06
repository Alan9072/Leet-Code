class Solution {
    public int candy(int[] ratings) {
        int[] candies1 = new int[ratings.length];
        int[] candies2 = new int[ratings.length];
        Arrays.fill(candies1, 1);
        Arrays.fill(candies2, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (candies1[i] <= candies1[i - 1] && ratings[i] > ratings[i - 1]) {
                candies1[i] = candies1[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies2[i] = candies2[i + 1] + 1;
            }
        }
        int count = 0;
        for(int i=0;i<ratings.length;i++){
            count += Math.max(candies1[i],candies2[i]);
        }

        return count;

    }
}
