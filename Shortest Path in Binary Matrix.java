class Pair{
    int i;
    int j;
    int distance;
    Pair(int i,int j,int distance){
        this.i = i;
        this.j = j;
        this.distance = distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length - 1;
        if(grid[0][0] == 1 || grid[n][n] == 1)return -1;

        HashSet<String> visited = new HashSet<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,1));
        visited.add(0 +"," + 0);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(curr.i == n && curr.j == n){
                return curr.distance;
            }
            
            if (curr.i - 1 >= 0 && grid[curr.i - 1][curr.j] == 0 && !visited.contains((curr.i - 1) + "," + curr.j)) {
                visited.add((curr.i - 1) + "," + curr.j);
                q.add(new Pair(curr.i - 1, curr.j, curr.distance + 1));
            }

            if (curr.i + 1 < grid.length && grid[curr.i + 1][curr.j] == 0 && !visited.contains((curr.i + 1) + "," + curr.j)) {
                visited.add((curr.i + 1) + "," + curr.j);
                q.add(new Pair(curr.i + 1, curr.j, curr.distance + 1));
            }

            if (curr.j - 1 >= 0 && grid[curr.i][curr.j - 1] == 0 && !visited.contains(curr.i + "," + (curr.j - 1))) {
                visited.add(curr.i + "," + (curr.j - 1));
                q.add(new Pair(curr.i, curr.j - 1, curr.distance + 1));
            }

            if (curr.j + 1 < grid[0].length && grid[curr.i][curr.j + 1] == 0 && !visited.contains(curr.i + "," + (curr.j + 1))) {
                visited.add(curr.i + "," + (curr.j + 1));
                q.add(new Pair(curr.i, curr.j + 1, curr.distance + 1));
            }

            if (curr.i - 1 >= 0 && curr.j - 1 >= 0 && grid[curr.i - 1][curr.j - 1] == 0 && !visited.contains((curr.i - 1) + "," + (curr.j - 1))) {
                visited.add((curr.i - 1) + "," + (curr.j - 1));
                q.add(new Pair(curr.i - 1, curr.j - 1, curr.distance + 1));
            }

            if (curr.i - 1 >= 0 && curr.j + 1 < grid[0].length && grid[curr.i - 1][curr.j + 1] == 0 && !visited.contains((curr.i - 1) + "," + (curr.j + 1))) {
                visited.add((curr.i - 1) + "," + (curr.j + 1));
                q.add(new Pair(curr.i - 1, curr.j + 1, curr.distance + 1));
            }

            if (curr.i + 1 < grid.length && curr.j - 1 >= 0 && grid[curr.i + 1][curr.j - 1] == 0 && !visited.contains((curr.i + 1) + "," + (curr.j - 1))) {
                visited.add((curr.i + 1) + "," + (curr.j - 1));
                q.add(new Pair(curr.i + 1, curr.j - 1, curr.distance + 1));
            }

            if (curr.i + 1 < grid.length && curr.j + 1 < grid[0].length && grid[curr.i + 1][curr.j + 1] == 0 && !visited.contains((curr.i + 1) + "," + (curr.j + 1))) {
                visited.add((curr.i + 1) + "," + (curr.j + 1));
                q.add(new Pair(curr.i + 1, curr.j + 1, curr.distance + 1));
            }

            

        }
         return -1;
    }
}
