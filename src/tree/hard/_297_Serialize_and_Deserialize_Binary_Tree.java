package tree.hard;

import java.util.Stack;

public class _297_Serialize_and_Deserialize_Binary_Tree {

    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * Example:
     *
     * You may serialize the following tree:
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * as "[1,2,3,null,null,4,5]"
     * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
     *
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     *
     * 易错题。
     * TreeNode的 val 不一定是one digit number.
     * val还有可能是负数。deserialize的时候要注意。
     *
     */

    public String serialize(TreeNode root) {
        /**
         * recursion.
         * preorder
         * null: ""
         * root
         * (+left+)
         * (+right+)
         * ex: 1, (2) (3,(4),(5))
         * ex 1()()
         *
         *    1
         *   / \
         *  9  2
         * / \
         * 8  10
         *
         * 1(9(8()())(10()()))(2()())
         */

        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("(");
        sb.append(serialize(root.left));
        sb.append(")");
        sb.append("(");
        sb.append(serialize(root.right));
        sb.append(")");
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        /**
         * 1 (2 () ()) (3 (4 () ()) (5()()))
         * 1 (9 (8()()) (10()()) ) (2()())
         * null || empty ret null
         * is(!digit) throw ex;
         * newNode
         * leftindex=?
         * rightindex=?
         * newNode.left= des()
         * newNode.right= des()
         * ret newNode
         *
         * helpder: findRight(int index, String data) using stack.
         *
         * ex:1()()
         */
        if (data == null || data.length() == 0) return null;
        int num = firstNum(data);
        TreeNode node = new TreeNode(Integer.valueOf(data.substring(0, num)));//1
        //left child: 1-? right child: ?-end
        int leftBound = findRight(num, data);//18
        node.left = deserialize(data.substring(num+1, leftBound));
        node.right = deserialize(data.substring(leftBound+2, data.length() - 1));

        return node;
    }

    private int findRight(int index, String data) {//1
        //1, 1()()
        Stack<Character> stack = new Stack<>();
        for (int i = index+1; i < data.length(); i++) {
            if(data.charAt(i) == '(') stack.push('(');
            if(data.charAt(i) == ')') {
                if (stack.empty()) {
                    return i;
                } else {
                    stack.pop();
                }
            }
        }
        return -1;
    }

    private int firstNum(String data) {
        int i = 0;
        if (data.charAt(0) == '-')  i = 1;
        for (; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i))) {
                break;
            }
        }
        return i;
    }

}
