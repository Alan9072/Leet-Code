class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = 0;
        int empty = 0;
        while (true) {
            drink += numBottles;
            empty += numBottles;
            //excahneg

            numBottles = empty / numExchange;
            if (numBottles == 0)
                break;
            empty = empty % numExchange;
        }
        return drink;
    }
}
