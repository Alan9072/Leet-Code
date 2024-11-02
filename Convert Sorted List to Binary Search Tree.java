class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        fast = slow.next;
        if (prev != null) {
            prev.next = null;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(fast);

        return root;
    }
}