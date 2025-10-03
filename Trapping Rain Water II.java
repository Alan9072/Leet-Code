class Pair{
    int height;
    int row;
    int col;
    Pair(int height,int row,int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.height - b.height;
        });
        int n = heightMap.length;
        int m = heightMap[0].length;

        int[][] visited = new int[n][m];

        //top - bottom
        for(int i=0;i<m;i++){
            if(visited[0][i] == 0){
                visited[0][i] = 1;
                pq.add(new Pair(heightMap[0][i],0,i));
            }

            if(visited[n-1][i] == 0){
                visited[n-1][i] = 1;
                pq.add(new Pair(heightMap[n-1][i],n-1,i));
            }

        }
        //left - right
        for(int i=0;i<n;i++){
            if(visited[i][0] == 0){
                visited[i][0] = 1;
                pq.add(new Pair(heightMap[i][0],i,0));
            }

            if(visited[i][m-1] == 0){
                visited[i][m-1] = 1;
                pq.add(new Pair(heightMap[i][m-1],i,m-1));
            }

        }

        int trapped = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            for(int[] arr: dirs){
                int nrow = curr.row + arr[0];
                int ncol = curr.col + arr[1];

                if(nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && visited[nrow][ncol] == 0){
                    visited[nrow][ncol] = 1;

                    if(heightMap[nrow][ncol] < curr.height){
                        trapped += curr.height - heightMap[nrow][ncol];
                    }

                    pq.add(new Pair(Math.max(heightMap[nrow][ncol],curr.height),nrow,ncol));
                }
            }
        }
        return trapped;
    }
}
