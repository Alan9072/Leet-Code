class Pair {
    int i;
    int j;
    int time;

    Pair(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[grid.length][grid.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });

        pq.add(new Pair(0, 0, grid[0][0]));
        visited[0][0] = 1;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            if(curr.i == n-1 && curr.j == n-1)return curr.time;

            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };

            for (int dir = 0; dir < 4; dir++) {
                int newX = dx[dir] + curr.i;
                int newY = dy[dir] + curr.j;

                // check boundaries
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                    visited[newX][newY] = 1;
                    if(grid[newX][newY] > curr.time){
                        pq.add(new Pair(newX,newY,grid[newX][newY]));
                    }else{
                        pq.add(new Pair(newX,newY,curr.time));
                    }
                }
            }
        }
        return -1;
    }
}
