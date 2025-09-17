class Pair{
    String food;
    int rating;
    Pair(String food,int rating){
        this.food = food;
        this.rating = rating;
    }
}
class FoodRatings {
    Map<String,PriorityQueue<Pair>> map ;
    Map<String,Pair> subMap ;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        subMap = new HashMap<>();
        for(int i=0;i<foods.length;i++){
            Pair curr = new Pair(foods[i],ratings[i]);

            map.putIfAbsent(cuisines[i],new PriorityQueue<>((a, b) -> a.rating == b.rating ? 
            a.food.compareTo(b.food) : b.rating - a.rating));

            map.get(cuisines[i]).add(new Pair(foods[i],ratings[i]));

            subMap.put(foods[i],new Pair(cuisines[i],ratings[i]));
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        subMap.get(food).rating = newRating;
        map.get(subMap.get(food).food).add(new Pair(food,newRating));

    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = map.get(cuisine);
        Pair curr = pq.poll();
        while(subMap.get(curr.food).rating != curr.rating){
            curr = pq.poll();
        }

        pq.add(curr);
        return curr.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
