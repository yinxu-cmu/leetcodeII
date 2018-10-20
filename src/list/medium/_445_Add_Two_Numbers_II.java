package list.medium;

import java.util.Stack;

public class _445_Add_Two_Numbers_II {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Follow up:
     * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     *
     * Example:
     *
     * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 8 -> 0 -> 7
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode cur1 = l1, cur2 = l2, res = null, pre = null;
        while (cur1 != null) {
            s1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            s2.push(cur2.val);
            cur2 = cur2.next;
        }
        //[7,2,4,3] 3427
        //[5,6,4]   465
        int add = 0;
        ListNode newNode = null;
        while (!s1.empty() || !s2.empty() || add != 0) {
            int n1 = 0, n2 = 0;
            if (!s1.empty()) n1 = s1.pop();//4
            if (!s2.empty()) n2 = s2.pop();//6
            newNode = new ListNode( (n1+n2+add) % 10);
            if (n1 + n2 + add > 9) add = 1;
            else add = 0;
            newNode.next = pre;
            pre = newNode;
        }
        return newNode;
    }
}
