class Solution {
    public int largestIsland(int[][] grid) {
        int max=0,n=grid.length;
        int[][] visited=new int[n][n];
        Map<Integer,Integer> map=new HashMap<>();
        int cntr=2;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1 && visited[i][j]==0){
                    int size=dfs(i,j,visited,grid,cntr);
                    max=Math.max(size,max);
                    map.put(cntr,size);
                    cntr++;
                }
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==0){
                    int[] x=new int[]{0,1,0,-1};
                    int[] y=new int[]{1,0,-1,0};
                    int size=0;
                    Set<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nX=x[k]+i,nY=y[k]+j;
                        if(nX<0||nX>=visited.length||nY<0||nY>=visited.length||grid[nX][nY]==0) continue;
                        int col=grid[nX][nY];
                        if(!set.contains(col)){ size+=map.get(col); set.add(col);}
                    }
                    max=Math.max(size+1,max);
                }
        return max;
    }

    public int dfs(int i,int j,int[][] visited,int[][] grid,int color){
        visited[i][j]=1;
        grid[i][j]=color;
        int[] x=new int[]{0,1,0,-1};
        int[] y=new int[]{1,0,-1,0};
        int size=0;
        for(int k=0;k<4;k++){
            int nX=x[k]+i,nY=y[k]+j;
            if(nX<0||nX>=visited.length||nY<0||nY>=visited.length||visited[nX][nY]==1||grid[nX][nY]==0) continue;
            size+=dfs(nX,nY,visited,grid,color);
        }
        return size+1;
    }
}
