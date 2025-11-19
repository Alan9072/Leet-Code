class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> seated = new PriorityQueue<>((a,b)->{
            return a[0] - b[0];
        });
        PriorityQueue<Integer> free = new PriorityQueue<>();

        int idx = targetFriend;
        int st = times[idx][0];
        int ed = times[idx][1];

        Arrays.sort(times,(a,b)->{
            return a[0] - b[0];
        });

        int chair = 0;
        for(int[] t : times){
            int start = t[0];
            int end = t[1];

            while(!seated.isEmpty() && seated.peek()[0] <= start){
                int[] arr = seated.poll();
                free.add(arr[1]);
            }

            int currAssigned;
            if(!free.isEmpty()){
                currAssigned = free.poll();
            }else{
                currAssigned = chair;
                chair++;
            }

            if(start == st && end == ed)return currAssigned;

            seated.add(new int[]{end,currAssigned});

        }
        return -1;

    }
}
