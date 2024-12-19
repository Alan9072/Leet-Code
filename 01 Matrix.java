//Here we start from 0 (useing bfs on 0 not 1)
//for each adjacent cell add distance + 1 and put in the queue
class Pair {
    int i;
    int j;
    int distance;
    Pair(int i, int j,int distance) {
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    // result[i][j] = 0;
                    visited[i][j] = 1;
                    q.add(new Pair(i, j,0));
                }
            }
        }
         while (!q.isEmpty()) {
                Pair pair = q.poll();
                int i = pair.i;
                int j = pair.j;
                
                result[i][j] = pair.distance;
                
                if (pair.i - 1 >= 0 && visited[pair.i-1][pair.j] == 0){
                    visited[pair.i-1][pair.j] = 1;
                    q.add(new Pair(pair.i - 1, pair.j,pair.distance + 1));
                }

                if (pair.i + 1 < mat.length && visited[pair.i+1][pair.j] == 0){ 
                    visited[pair.i+1][pair.j] = 1;   
                    q.add(new Pair(pair.i + 1, pair.j,pair.distance + 1));
                }
                
                if (pair.j - 1 >= 0 && visited[pair.i][pair.j-1] == 0){
                    visited[pair.i][pair.j-1] = 1;
                    q.add(new Pair(pair.i, pair.j - 1,pair.distance + 1));
                }
                    
                if (pair.j + 1 < mat[0].length && visited[pair.i][pair.j+1] == 0){
                    visited[pair.i][pair.j+1] = 1;
                    q.add(new Pair(pair.i, pair.j + 1,pair.distance + 1));
                }
         }
        return result;

    }

}
