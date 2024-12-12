class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int result[] = new int[nums.length - k + 1];
        int pos = 0;

        int left = 0;
        int right = 0;
        for(right = 0;right < k;right++){
            while(dq.size() != 0 && dq.getLast() < nums[right]){
                dq.removeLast();
            }
            dq.addLast(nums[right]);
        }

        while(right < nums.length){
            result[pos] = dq.getFirst();
            pos++;

            if(nums[left] == dq.getFirst()){
                dq.removeFirst();
            }
            left++;

            while(dq.size() != 0 && dq.getLast() < nums[right]){
                dq.removeLast();
            }
            dq.addLast(nums[right]);
            right++;
        }
        result[pos] = dq.getFirst();
        return result;

    }
}
