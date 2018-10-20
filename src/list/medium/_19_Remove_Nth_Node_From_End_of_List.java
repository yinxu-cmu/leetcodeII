package list.medium;

public class _19_Remove_Nth_Node_From_End_of_List {
    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     *
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     *
     * Given n will always be valid.
     *
     * Follow up:
     *
     * Could you do this in one pass?
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode left = head, right = head;
        int i = 0;
        while (i < n && right != null) {
            right = right.next;
            i++;
        }
        ListNode pre = null;
        while (right != null) {
            pre = left;
            left = left.next;
            right = right.next;
        }
        //remove left
        if (pre != null) pre.next = left.next;//ATTN 边界条件
        else return head.next;
        return head;
    }
}
