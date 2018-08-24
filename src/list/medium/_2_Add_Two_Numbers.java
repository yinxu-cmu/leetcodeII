package list.medium;

public class _2_Add_Two_Numbers {

    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * 注意考虑边界条件。
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //int flag store digit.
        //at last, reach list end, if flag still true, add extra 1.
        //1-2-3-4
        //5-6-7
        ListNode p1 = l1, p2 = l2;
        ListNode res = null, pre = null,cur = null;
        int flag = 0;
        while (p1 != null || p2 != null) {
            int val = 0;
            if (p1 != null && p2 != null) val = p1.val + p2.val;
            if (p1 == null) val = p2.val;
            if (p2 == null) val = p1.val;

            if (flag == 1) {
                val++;
                flag = 0;
            }

            if (val >= 10) {
                val = val - 10;
                flag = 1;
            }

            cur = new ListNode(val);
            if (pre == null) {
                res = cur;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if (p1 == null) {
                p2 = p2.next;
            } else if (p2 == null) {
                p1 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }

        }

        if (flag == 1) {
            pre.next = new ListNode(1);
        }
        return res;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
