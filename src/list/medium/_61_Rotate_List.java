package list.medium;

public class _61_Rotate_List {
    /**
     * Given a linked list, rotate the list to the right by k places, where k is non-negative.
     *
     * Example 1:
     *
     * Input: 1->2->3->4->5->NULL, k = 2
     * Output: 4->5->1->2->3->NULL
     * Explanation:
     * rotate 1 steps to the right: 5->1->2->3->4->NULL
     * rotate 2 steps to the right: 4->5->1->2->3->NULL
     * Example 2:
     *
     * Input: 0->1->2->NULL, k = 4
     * Output: 2->0->1->NULL
     * Explanation:
     * rotate 1 steps to the right: 2->0->1->NULL
     * rotate 2 steps to the right: 1->2->0->NULL
     * rotate 3 steps to the right: 0->1->2->NULL
     * rotate 4 steps to the right: 2->0->1->NULL
     */

    /**
     * 收尾连起来， 走step， 找到新head， 断开之前的next。
     */
    public ListNode rotateRight(ListNode head, int k) {
        //Input: 1->2->3->4->5->NULL, k = 2
        //Output: 4->5->1->2->3->NULL
        //find end
        if (head == null || head.next == null) return head;
        ListNode tmp = head;
        ListNode pre = null;
        int size = 0;
        while (tmp != null) {
            size++;
            pre = tmp;
            tmp = tmp.next;
        }
        //link tail to head
        pre.next = head;
        //k step
        ListNode newHead = head;
        ListNode newPre = null;
        for (int i = 0; i < size - (k % size); i++) {
            newPre = newHead;
            newHead = newHead.next;
        }
        newPre.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
