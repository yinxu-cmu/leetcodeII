package tree.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_N_ary_Tree_Level_Order_Traversal {

    /**
     * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example, given a 3-ary tree:
     *
     *
     *
     *
     *
     * We should return its level order traversal:
     *
     *
     *
     *
     *
     * [
     *      [1],
     *      [3,2,4],
     *      [5,6]
     * ]
     *
     *
     * Note:
     *
     * The depth of the tree is at most 1000.
     * The total number of nodes is at most 5000.
     *
     * LEVEL order traversal 典型实现. 用queue做分层。
     *
     */

    public List<List<Integer>> levelOrder(Node root) {
        //BFS
        //queue
        //root, pop, size, node.child.addqueue.
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {//2
                Node node = q.poll();//3
                if (node.children != null) {
                    for (Node item: node.children) {
                        q.offer(item);
                    }
                }
                list.add(node.val);//[2,3]
            }

            res.add(list);
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
