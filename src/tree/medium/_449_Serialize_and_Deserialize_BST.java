package tree.medium;

import java.util.Stack;

public class _449_Serialize_and_Deserialize_BST {
    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
     *
     * The encoded string should be as compact as possible.
     *
     * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
     *
     */

    /**
     *    1
     *   / \
     *  2  3
     *  易错题。
     *  参考536和606.
     *
     *  写deserialize的时候一定要注意val为不止一位数字的情况。
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode t) {
        if (t == null) {
            return "";
        }

        String res = "";
        res += String.valueOf(t.val);

        String left = serialize(t.left);
        String right = serialize(t.right);

        if (left == "" && right == "") {
            return res;
        }
        if (left == "") {
            return res + "()" + "(" + right + ")";
        }
        if (right == "") {
            return res + "(" + left + ")";
        }
        return res + "(" + left + ")" + "(" + right + ")";
    }

    // Decodes your encoded data to tree.
    //2(1(1)(10))
    //1(1)(10)
    //2(1)
    //10(10)
    public TreeNode deserialize(String s) {
        if (s == null || s.length() == 0) return null;
        int index = s.indexOf("(");//2
        int num = 0;
        TreeNode root;
        if (index == -1) {
            num = Integer.valueOf(s);
            root = new TreeNode(num);
            return root;
        } else {
            num = Integer.valueOf(s.substring(0, index));
            root = new TreeNode(num);
        }

        int right = findRight(s);//3
        root.left = deserialize(s.substring(index + 1, right));
        if (right  < s.length() - 1) {
            root.right = deserialize(s.substring(right+2, s.length() - 1));//5,7
        }

        return root;
    }

    //2(1(1)(10))
    //10(10)
    private int findRight(String s) {
        Stack<Character> stack = new Stack<>();
        int index = s.indexOf("(");
        stack.push('(');

        for (int i = index + 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(ch);
            else if (ch == ')') stack.pop();
            if (stack.empty()) return i;
        }

        return -1;
    }
}
