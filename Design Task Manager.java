class Pair{
    int uid;
    int tid;
    int prio;
    Pair(int uid,int tid,int prio){
        this.uid = uid;
        this.tid = tid;
        this.prio = prio;
    }
}
class TaskManager {
    PriorityQueue<Pair> pq;
    Map<Integer,int[]> map;
    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a,b)->{
           return  b.prio == a.prio ? b.tid - a.tid : b.prio - a.prio;
        });
        map = new HashMap<>();

        for(List<Integer> list : tasks){
            Pair curr = new Pair(list.get(0),list.get(1),list.get(2));
            pq.add(curr);
            map.put(list.get(1),new int[]{list.get(0),list.get(2)});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Pair curr = new Pair(userId,taskId,priority);
        pq.add(curr);
        map.put(taskId,new int[]{userId,priority});
    }
    
    public void edit(int taskId, int newPriority) {
        int[] arr = map.get(taskId);
        arr[1] = newPriority;

        pq.add(new Pair(arr[0],taskId,newPriority));
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        if(pq.isEmpty())return -1;

        Pair curr = pq.poll();
        while(true){

            if(map.containsKey(curr.tid)){
                if(map.get(curr.tid)[1] == curr.prio){
                    int[] arr = map.remove(curr.tid);
                    return arr[0];
                }
            }

            if(!pq.isEmpty()){
                curr = pq.poll();
            }else{
                return -1;
            }

        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
