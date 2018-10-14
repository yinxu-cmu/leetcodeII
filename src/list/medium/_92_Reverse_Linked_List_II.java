package list.medium;

public class _92_Reverse_Linked_List_II {
    /**
     * Reverse a linked list from position m to n. Do it in one-pass.
     *
     * Note: 1 ≤ m ≤ n ≤ length of list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL, m = 2, n = 4
     * Output: 1->4->3->2->5->NULL
     */

    // 先把3插入到1和2中间， 再把4插入到1和3中间，以此类推。
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        for (int i = 1; i < m; i++) {
            start = start.next;
        }
        //1->2->3->4->5->NULL
        //1->3->2->4->5
        //1->4->3->2->5->NULL
        ListNode cur = start.next;//3
        ListNode pre = start.next;//3
        ListNode target = null;
        for (int j = 0; j < n-m; j++) {
            target = cur.next;//5
            start.next = target;//d-5-3-null
            cur.next = target.next;//1-4-3-2-5
            target.next = pre;//1-4-3-2
            pre = target;//4
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseBetween(n1, 2, 4);

        ListNode cur = n1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
