package microsoft;

import java.util.HashSet;
import java.util.List;

public class Sort_Doubly_Linked_List {
    /**
     * 双向链表只包含 0 和 1，排序，复杂度要求 O(n)
     *
     * swap
     */
    static class ListNode {
        ListNode next;
        ListNode pre;
        int val;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode sort(ListNode h, ListNode t) {
        // 0-1-0-1
        ListNode head = h;
        ListNode tail = t;
        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(head)) {
            set.add(tail);
            if (head.val == 0) {
                head = head.next;
                continue;
            }
            if (tail.val == 1) {
                tail = tail.pre;
                continue;
            }

//            swap(head, tail);
            head.val = 0;
            tail.val = 1;
            head = head.next;
            tail = tail.pre;
        }
        return h;
    }

    public static void swap(ListNode a , ListNode b) {
        ListNode aNext = null, aPre = null;
        ListNode bNext = null, bPre = null;
        aNext = a.next;
        aPre = a.pre;
        bNext = b.next;
        bPre = b.pre;

        aPre.next = b;
        b.pre = aPre;
        b.next = aNext;

        bPre.next = a;
        a.pre = bPre;
        a.next = bNext;

    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next =n3;
        n3.next = n4;
        n2.pre = n1;
        n3.pre = n2;
        n4.pre = n3;

        ListNode cur = sort(n1, n4);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
