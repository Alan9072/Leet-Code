class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Stack<Integer> list = new Stack<>();
    
        for(int i=0;i<temperatures.length;i++){
            while(!list.isEmpty() && temperatures[i] > temperatures[list.peek()]){
                
                    int index = list.pop();
                    arr[index] = i - index;
                    
            }
            list.push(i);
            
        }
        return arr;
    }
}
