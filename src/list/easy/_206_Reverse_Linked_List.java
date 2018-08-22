package list.easy;

public class _206_Reverse_Linked_List {

    //easy
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        ListNode pre = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre; //ATTN
    }
}
