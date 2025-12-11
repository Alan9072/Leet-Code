class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,TreeSet<Pair>> x = new HashMap<>();
        Map<Integer,TreeSet<Pair>> y = new HashMap<>();

        for(int[] node : buildings){// for x axis
            x.putIfAbsent(node[0],new TreeSet<>((a,b)->{
                return a.y - b.y;
            }));
            x.get(node[0]).add(new Pair(node[0],node[1]));
        }
        for(int[] node : buildings){// for y axis
            y.putIfAbsent(node[1],new TreeSet<>((a,b)->{
                return a.x - b.x;
            }));
            y.get(node[1]).add(new Pair(node[0],node[1]));
        }

        int count = 0;
        for(int coord[] : buildings){
            TreeSet<Pair> xc= x.get(coord[0]);
            TreeSet<Pair> yc= y.get(coord[1]);
            if(xc.first().y < coord[1] && xc.last().y > coord[1] && yc.first().x < coord[0] && yc.last().x > coord[0]){
                count++;
            }
        }
        return count;
    }
}
