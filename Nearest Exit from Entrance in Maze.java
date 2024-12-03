class Solution {
    int shortest = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            int count = curr[2];

            if ((i == 0 || i == maze.length - 1 || j == 0 || j == maze[0].length - 1) && 
            !(i == entrance[0] && j == entrance[1]))
             {
                return count;
             }

            if(i > 0 && maze[i - 1][j] != '+'){
                maze[i - 1][j] = '+';
                q.add(new int[]{i-1,j,count + 1});
            }
            if(i < maze.length - 1  && maze[i + 1][j] != '+'){
                maze[i + 1][j] = '+';
                q.add(new int[]{i+1,j,count + 1});
            }
            if( j > 0 && maze[i][j - 1] != '+'){
                maze[i][j - 1] = '+';
                q.add(new int[]{i,j-1,count + 1});
            }
            if(j < maze[0].length - 1 && maze[i][j + 1] != '+'){
                maze[i][j + 1] = '+';
                q.add(new int[]{i,j+1,count + 1});
            }
        }

        return -1;

    }
    
}
