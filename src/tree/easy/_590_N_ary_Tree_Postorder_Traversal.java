package tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _590_N_ary_Tree_Postorder_Traversal {

    /**
     * Given an n-ary tree, return the postorder traversal of its nodes' values.
     *
     *
     * For example, given a 3-ary tree:
     *
     *
     *
     *
     * Return its postorder traversal as: [5,6,3,2,4,1].
     *
     *
     * Note: Recursive solution is trivial, could you do it iteratively?
     *
     * 和binary tree的 traversal 类似， 需要注意各种包装（box)之后的null pointer.
     */

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Box> stack = new Stack<>();
        stack.push(new Box(root, 0));

        while (!stack.empty()) {
            Box box = stack.pop();
            if (box.node != null) {
                if (box.opt == 0) {
                    stack.push(new Box(box.node, 1));
                    if (box.node.children != null) {
                        int size = box.node.children.size();
                        for (int i = size - 1; i >= 0; i--) {
                            stack.push(new Box(box.node.children.get(i), 0));
                        }
                    }

                } else {
                    list.add(box.node.val);
                }
            }

        }
        return list;
    }

    class Box {
        int opt; //0, visit; 1, print
        Node node;

        public Box(Node node, int opt) {
            this.node = node;
            this.opt = opt;
        }
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
