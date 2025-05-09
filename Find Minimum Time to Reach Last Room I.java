////////////////////Time exceeded version///////////////////////////////////
class Pair {
    int i;
    int j;
    int dist;

    Pair(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}

class Solution {
    int minT = Integer.MAX_VALUE;
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean[][] visited = new boolean[n][m];

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)->{
            return a.dist - b.dist;
        });
        minHeap.add(new Pair(0, 0, 0));
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {

            Pair curr = minHeap.poll();
            int row = curr.i;
            int col = curr.j;
            if(row == n - 1 && col == m - 1){
                minT = curr.dist;
                return minT;
            }
            
            visited[row][col] = true;

            int[] dx = { 0, 0, -1, 1 }; // change in row
            int[] dy = { -1, 1, 0, 0 }; // change in column

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];
                if(nextRow >= moveTime.length || nextRow < 0 || nextCol >= moveTime[0].length || 
                nextCol < 0 || visited[nextRow][nextCol] == true){
                    continue;
                }
                if(moveTime[nextRow][nextCol] <= curr.dist){
                    minHeap.add(new Pair(nextRow,nextCol,curr.dist + 1));
                }else{
                    minHeap.add(new Pair(nextRow,nextCol,moveTime[nextRow][nextCol] + 1));
                }
            }
        }
        return minT;
    }
}
