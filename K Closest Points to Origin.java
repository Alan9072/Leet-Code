class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[0] - a[0]);
      
        for(int i=0;i<points.length;i++){
            int val = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int arr[] = new int[]{val , i};
            maxHeap.add(arr);

        }
        while(maxHeap.size() > k){
            maxHeap.poll();
        }
        int pos = 0;
        int result[][] = new int[k][2];
        for( int arr[] : maxHeap){
            result[pos] = points[arr[1]];
            pos++;
        }
        return result;
        
    }
}
