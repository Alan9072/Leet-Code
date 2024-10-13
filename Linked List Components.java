class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int connected = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int val : nums) {
            set.add(val);
        }

        ListNode pointer = head;
        boolean inComponent = false;

        while (pointer != null) {
            if (set.contains(pointer.val)) {
                if (!inComponent) {
                    connected++;
                    inComponent = true; 
                }
            } else {
                inComponent = false;
            }
            pointer = pointer.next;
        }

        return connected;
    }
}
