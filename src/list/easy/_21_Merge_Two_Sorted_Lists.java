package list.easy;

public class _21_Merge_Two_Sorted_Lists {

    /**
     * 挨个儿比较。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = null, pre = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 != null) {
            ListNode node;
            if (cur1.val <= cur2.val) {
                node = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                node = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            if (res == null) {
                res = node;
                pre = node;
            } else {
                pre.next = node;
                pre = pre.next;
            }
        }

        if(cur1 == null && cur2 != null) {
            while(cur2 != null) {
                pre.next = new ListNode(cur2.val);
                pre = pre.next;
                cur2 = cur2.next;
            }
        }

        if(cur2 == null && cur1 != null) {
            while(cur1 != null) {
                pre.next = new ListNode(cur1.val);
                pre = pre.next;
                cur1 = cur1.next;
            }
        }
        return res;
    }
}
