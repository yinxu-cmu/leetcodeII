package string.easy;

import java.util.Stack;

public class _606_Construct_String_from_Binary_Tree {

    /**
     * interesting. 需要revisit。
     *
     *
     */

    /**
     * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
     *
     * The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     *
     * Example 1:
     * Input: Binary tree: [1,2,3,4]
     *        1
     *      /   \
     *     2     3
     *    /
     *   4
     *
     * Output: "1(2(4))(3)"
     *
     * Explanation: Originallay it needs to be "1(2(4)())(3()())",
     * but you need to omit all the unnecessary empty parenthesis pairs.
     * And it will be "1(2(4))(3)".
     * Example 2:
     * Input: Binary tree: [1,2,3,null,4]
     *        1
     *      /   \
     *     2     3
     *      \
     *       4
     *
     * Output: "1(2()(4))(3)"
     *
     * Explanation: Almost the same as the first example,
     * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the in
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String res = "";
        res += String.valueOf(t.val);

        String left = tree2str(t.left);
        String right = tree2str(t.right);

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

    /**
     * Stack. Iterative.
     * @param t
     * @return
     */
    public String tree2strIte(TreeNode t) {
        if (t == null) {
            return "";
        }
        Stack<Wrap> stack = new Stack<>();
        stack.push(new Wrap(t, 0));
        StringBuilder res = new StringBuilder();

        //1, 2, 3, 4
        //(1(2(4))(3))

        while(!stack.empty()) {
            Wrap item = stack.pop();
            if (item.opt == 0) {
                res.append("(" + item.node.val);
                stack.push(new Wrap(null, 1));
                if (item.node.left == null && item.node.right != null) {
                    res.append("()");
                }
                if (item.node.right != null) {
                    stack.push(new Wrap(item.node.right, 0));
                }
                if (item.node.left != null) {
                    stack.push(new Wrap(item.node.left, 0));
                }
//                 if (item.node.left == null && item.node.right == null) {

//                 }

            } else {
                res.append(")");
            }
        }

        return res.toString().substring(1, res.length()-1);

    }


     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    private class Wrap {
        TreeNode node;
        int opt; //0, visit, 1, print
        public Wrap(TreeNode node, int opt) {
            this.node = node;
            this.opt = opt;
        }
    }
}
