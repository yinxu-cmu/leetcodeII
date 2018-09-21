package tree.medium;

import java.util.Stack;

public class _536_Construct_Binary_Tree_from_String {
    /**
     * 对比 第606题
     * You need to construct a binary tree from a string consisting of parenthesis and integers.
     *
     * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
     *
     * You always start to construct the left child node of the parent first if it exists.
     *
     * Example:
     *
     * Input: "4(2(3)(1))(6(5))"
     * Output: return the tree root node representing the following tree:
     *
     *        4
     *      /   \
     *     2     6
     *    / \   /
     *   3   1 5
     *
     *
     * Note:
     *
     * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
     * An empty tree is represented by "" instead of "()".
     *
     * 4()(1)
     * 4(6)
     */

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0,1)));
        if (s.length() == 1) return root;
        int right = findRight(s);
        root.left = str2tree(s.substring(1, right + 1));
        root.right = str2tree(s.substring(right+2, s.length()));
        return root;
    }

    private int findRight(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 2; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(ch);
            else if (ch == ')') stack.pop();
            if (stack.empty()) return i;
        }

        return -1;
    }

}
