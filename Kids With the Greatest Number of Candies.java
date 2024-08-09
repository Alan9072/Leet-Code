class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int greatest = 0;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>greatest){
                greatest = candies[i];
            }
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies >= greatest){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}
