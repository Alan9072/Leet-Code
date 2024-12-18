class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int curr = prices[i];
            boolean flag = false;
            for(int j = i+1;j<prices.length;j++){
                if(j > i && prices[j] <= prices[i]){
                    result[i] = prices[i] - prices[j];
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                result[i] = curr;            
            }
        }
        return result;
    }
}
