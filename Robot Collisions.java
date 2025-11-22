class Pair{
    int pos;
    int health;
    char dir;
    int ridx;
    Pair(int pos,int health,char dir,int ridx){
        this.pos = pos;
        this.health = health;
        this.dir = dir;
        this.ridx = ridx;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Pair> sorted = new ArrayList<>();
        for(int i=0;i<positions.length;i++){
            Pair curr = new Pair(positions[i],healths[i],directions.charAt(i),i);
            sorted.add(curr);
        }

        Collections.sort(sorted,(a,b)->{
            return a.pos - b.pos;
        });

        Stack<Pair> stk = new Stack<>();
        for(Pair curr : sorted){
            if(stk.isEmpty() || curr.dir == 'R'){
                stk.push(curr);
            }else if(curr.dir == 'L'){
                if(stk.peek().dir == 'R'){
                    while(!stk.isEmpty() && stk.peek().dir == 'R'){
                        if(stk.peek().health < curr.health){
                            stk.pop();
                            curr.health -= 1;//sonething fishy
                            if(stk.isEmpty() || stk.peek().dir == 'L'){
                                stk.push(curr);
                                break;
                            }
                        }else if(stk.peek().health > curr.health){
                            stk.peek().health -= 1;
                            break;
                        }else{
                            stk.pop();
                            break;
                        }
                    }
                }else{
                    stk.push(curr);
                }
            }
        }

        List<Pair> sub = new ArrayList<>();
        while(!stk.isEmpty()){
            sub.add(stk.pop());
        }

        Collections.sort(sub,(a,b)->{
            return a.ridx - b.ridx;
        });

        List<Integer> result = new ArrayList<>();
        for(Pair p : sub){
            result.add(p.health);
        }
        return result;
        
    }
}
