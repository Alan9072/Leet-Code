class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drink = 0;
        int empty = 0;
        while(true){
            drink += numBottles;
            empty += numBottles;
            numBottles = 0;

            if(empty - numExchange < 0)return drink;
            //exchange

            while(empty - numExchange >= 0){
                empty -= numExchange;
                numExchange++;
                numBottles++;
            }
        }
    }
}
