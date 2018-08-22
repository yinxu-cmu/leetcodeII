package list.easy;

public class _203_Remove_Linked_List_Elements {

    //easy.
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }

        return head;
    }
}
