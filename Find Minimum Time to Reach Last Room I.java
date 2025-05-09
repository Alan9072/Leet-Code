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
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] minTime = new int[n][m];

        for (int[] row : minTime)
            Arrays.fill(row, Integer.MAX_VALUE);
        minTime[0][0] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            return a.dist - b.dist;
        });
        minHeap.add(new Pair(0, 0, 0));
        minTime[0][0] = 0;

        int[] dx = { -1, 1, 0, 0 }; // ⬆️⬇️ change in row
        int[] dy = { 0, 0, -1, 1 }; // ⬅️➡️ change in column

        while (!minHeap.isEmpty()) {

            Pair curr = minHeap.poll();
            int row = curr.i;
            int col = curr.j;

            if (row == n - 1 && col == m - 1) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                if (nextRow >= moveTime.length || nextRow < 0 || nextCol >= moveTime[0].length ||
                        nextCol < 0) {
                    continue;
                }

                int distance = 0;
                if (curr.dist >= moveTime[nextRow][nextCol]) {
                    distance = curr.dist + 1;
                } else {
                    distance = moveTime[nextRow][nextCol] + 1;
                }

                if (distance < minTime[nextRow][nextCol]) {
                    minTime[nextRow][nextCol] = distance;
                    minHeap.add(new Pair(nextRow, nextCol, distance));
                }
            }
        }
        return -1;
    }
}
////////////////////Time exceeded version (wrong answer)///////////////////////////////////
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
