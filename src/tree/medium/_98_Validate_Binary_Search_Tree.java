package tree.medium;

import java.util.Stack;

public class _98_Validate_Binary_Search_Tree {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than the node's key.
     * The right subtree of a node contains only nodes with keys greater than the node's key.
     * Both the left and right subtrees must also be binary search trees.
     * Example 1:
     *
     * Input:
     *     2
     *    / \
     *   1   3
     * Output: true
     * Example 2:
     *
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * Output: false
     * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
     *              is 5 but its right child's value is 4.
     */

    public boolean isValidBST(TreeNode root) {
        /**
         * isValid(left) && isValid(right)
         * rightmost(left) < root && leftmost(right) > root
         *
         */
        if (root == null) return true;
        if (!isValidBST(root.left) || !isValidBST(root.right)) return false;
        if (root.left != null && getBound(root.left, true) >= root.val) return false;
        if (root.right != null && getBound(root.right, false) <= root.val) return false;

        return true;
    }

    private int getBound(TreeNode node, boolean right) {
        if (node == null) return right ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        TreeNode cur = node;
        if (right) {
            while (cur.right != null) {
                cur = cur.right;
            }
        } else {
            while (cur.left != null) {
                cur = cur.left;
            }
        }
        return cur.val;
    }

    /**
     * Iterative.
     *
     */
    public static boolean isValidBST1(TreeNode root) {
        /**
         * root
         * inorder traversal 单调递增。
         *   2
         *  / \
         * 1  3
         */
        if (root == null) return true;
        Stack<Box> stack = new Stack<>();//
        stack.push(new Box(root, 0));
        Integer pre = null;
        while(!stack.empty()) {
            Box box = stack.pop(); //(3,1)
            if (box.node != null) {
                if (box.opt == 1) {
                    if (pre == null) {
                        pre = box.node.val;
                        continue;
                    }
                    if (box.node.val <= pre) return false;
                    else pre = box.node.val;

                } else {
                    stack.push(new Box(box.node.right, 0));
                    stack.push(new Box(box.node, 1));
                    stack.push(new Box(box.node.left, 0));
                }
            }
        }
        return true;
    }

    static class Box {
        TreeNode node;
        int opt;//0 visit; 1 print
        public Box(TreeNode node, int opt) {
            this.node = node;
            this.opt = opt;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        isValidBST1(root);
    }
}
