package list.hard;

import java.util.PriorityQueue;

public class _23_Merge_k_Sorted_Lists {

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     */

    /**
     * 比较每个list的head，依次加入result。
     * time: O(kn)
     * space: O(n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        if (lists == null || lists.length == 0) return res;
        int size = 0;
        for (ListNode node : lists) {
            while(node != null) {
                size++;
                node = node.next;
            }
        }
        //1->4->5,
        //1->3->4,
        //2->6
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 0; i < size; i++) {
            int cur = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < lists.length; j++) {
                if (lists[j] != null && lists[j].val <= cur) {
                    cur = lists[j].val;
                    index = j;
                }
            }
            lists[index] = lists[index].next;
            ListNode newNode = new ListNode(cur);
            pre.next = newNode;
            pre = newNode;
        }

        return head.next;
    }

    /**
     * 高级解法。
     * min heap. Priority queue.
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode res = null;
        if (lists == null || lists.length == 0) return res;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (ListNode node : lists) {
            while(node != null) {
                q.offer(node.val);
                node = node.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (!q.isEmpty()) {
            int val = q.poll();
            ListNode newNode = new ListNode(val);
            pre.next = newNode;
            pre = newNode;
        }
        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
