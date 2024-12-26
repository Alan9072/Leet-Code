class Pair{
    int desc;
    int price;
    int count;
    Pair(int desc,int price,int count){
        this.desc = desc;
        this.price = price;
        this.count = count;
    }
    
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int min = Integer.MAX_VALUE;
        int[] minPrices = new int[n];
        for (int i = 0; i < n; i++) {
            minPrices[i] = Integer.MAX_VALUE;
        }

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int arr[] = flights[i];
            graph.get(arr[0]).add(new Pair(arr[1],arr[2],0));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();

            if(curr.count > k + 1){
                continue;
            }
            for(int i=0;i<graph.get(curr.desc).size();i++){
                Pair next = graph.get(curr.desc).get(i);
                int newPrice = curr.price + next.price;

                if(newPrice < minPrices[next.desc]){
                    minPrices[next.desc] = newPrice;
                    q.add(new Pair(next.desc,newPrice,curr.count + 1));
                }
                
            }
            if(curr.desc == dst){
                min = Math.min(min,curr.price);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
