package list.easy;

public class _160_Intersection_of_Two_Linked_Lists {

    /**
     *
     * two pointer。 每个pointer都把A和B走了， 消除size不一样带来的step差别。 在第二个iteration肯定能meet。
     * 如果没有intersection. P1和P2都指向null最后。 也满足要求。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
