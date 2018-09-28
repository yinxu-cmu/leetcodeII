package list.medium;

import java.util.ArrayList;
import java.util.List;

public class _725_Split_Linked_List_in_Parts {
    /**
     * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
     *
     * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
     *
     * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
     *
     * Return a List of ListNode's representing the linked list parts that are formed.
     *
     * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
     * Example 1:
     * Input:
     * root = [1, 2, 3], k = 5
     * Output: [[1],[2],[3],[],[]]
     * Explanation:
     * The input and each element of the output are ListNodes, not arrays.
     * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
     * The first element output[0] has output[0].val = 1, output[0].next = null.
     * The last element output[4] is null, but it's string representation as a ListNode is [].
     * Example 2:
     * Input:
     * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     * Explanation:
     * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
     * Note:
     *
     * The length of root will be in the range [0, 1000].
     * Each value of a node in the input will be an integer in the range [0, 999].
     * k will be an integer in the range [1, 50].
     */

    /**
     * 处理好特殊情况就好了。
     * ex:
     * [], 2
     * [1], 3
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode cur = root;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int avg = size / k;//0
        int ext = size % k;//1
        List<ListNode> res = new ArrayList<>();
        res.add(root);
        ListNode start = root;
        for (int i = 1; i < k;i++) {
            int step = avg;
            if (ext > 0) {
                step++;
                ext--;
            }
            ListNode pre = null;
            while (step > 0) {
                step--;
                pre = start;
                start = start.next;
            }
            if (pre != null) pre.next = null; //ATTN. 处理特殊情况。
            res.add(start);
        }
        return res.stream().toArray(ListNode[]::new);
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
}
