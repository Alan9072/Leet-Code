class Pair {
    int i;
    int j;
    int dist;
    int step;

    Pair(int i, int j, int dist, int step) {
        this.i = i;
        this.j = j;
        this.dist = dist;
        this.step = step;
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
        minHeap.add(new Pair(0, 0, 0 ,0));
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
                    if(curr.step % 2 == 0){
                        distance = curr.dist + 1;
                    }else{
                        distance = curr.dist + 2;
                    }
                    
                } else {
                    if(curr.step % 2 == 0){
                        distance = moveTime[nextRow][nextCol] + 1;
                    }else{
                        distance = moveTime[nextRow][nextCol] + 2;
                    }
                }

                if (distance < minTime[nextRow][nextCol]) {
                    minTime[nextRow][nextCol] = distance;
                    minHeap.add(new Pair(nextRow, nextCol, distance, curr.step + 1));
                }
            }
        }
        return -1;
    }
}
