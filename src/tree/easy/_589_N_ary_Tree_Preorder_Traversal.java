package tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _589_N_ary_Tree_Preorder_Traversal {

    /**
     * Given an n-ary tree, return the preorder traversal of its nodes' values.
     *
     *
     * For example, given a 3-ary tree:
     *
     *
     *
     *
     * Return its preorder traversal as: [1,3,5,6,2,4].
     *
     *
     * Note: Recursive solution is trivial, could you do it iteratively?
     */

    /**
     * 弱逼recursion.
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, list);
            }
        }
    }

    /**
     * iterative
     */
    public List<Integer> preorderIte(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            if (node.children != null) {
                int size = node.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
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
