package list.medium;

import java.util.HashMap;
import java.util.Map;

public class _138_Copy_List_with_Random_Pointer {

    /**
     * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
     *
     * Return a deep copy of the list.
     */

    /**
     * pre = new node
     * res = pre;
     * while(cur!=null)
     *   new node (cur.val)
     *
     *   if (cur.rd=null) newNode.rd=null.
     *   else
     *     map.contain: newNode.rd=get();
     *                : new node(); map.put();
     *   pre.next=newNode.
     *   pre = newNode.
     *
     * return res;
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head, pre = new RandomListNode(0), res = pre;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            if (cur.random == null) {
                newNode.random = null;
            } else {
                if (map.containsKey(cur.random)) {
                    newNode.random = map.get(cur.random);
                } else {
                    RandomListNode ranNode = new RandomListNode(cur.random.label);
                    map.put(cur.random, ranNode);
                    newNode.random = ranNode;
                }
            }
            pre.next = newNode;
            pre = newNode;
            cur = cur.next;
        }
        return res.next;
    }





    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }
}
