package list.easy;

import java.util.HashSet;
import java.util.Set;

public class _141_Linked_List_Cycle {

   //hash table
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = null;
        cur = head;
        while(cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }

    //two pointers
    public boolean hasCycleTwoPointer(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next; //ATTN. 搞成p2 = head 就出bug了
        while(p1 != null && p2 != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                p2 = p2.next;
            }
        }

        return false;
    }

}
