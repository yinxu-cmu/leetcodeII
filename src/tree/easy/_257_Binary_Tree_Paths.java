package tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _257_Binary_Tree_Paths {

    /**
     * Given a binary tree, return all root-to-leaf paths.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * Output: ["1->2->5", "1->3"]
     *
     * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     *
     * 中等难。 需要用两个stack! 一个存node， 一个存string。
     *
     *
     */

    public List<String> binaryTreePaths(TreeNode root) {
        //queue
        //pop, 1, node.left!=null, offer(left), right!=null, offer(right), left==null&&right==null, list.add(str+"->val"),.
        //1,2,3/ 1 ->2, 1 -> 3.
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<String> stackS = new Stack<>();
        stack.push(root);
        stackS.push("");

        while(!stack.empty()) {
            TreeNode node = stack.pop();//3
            String curStr = stackS.pop();//"1"
            if (curStr.length() == 0) {
                curStr += node.val;//"1"
            } else {
                curStr += "->" + node.val;//"1->3"
            }

            if (node.right != null) {
                stack.push(node.right);//3
                stackS.push(curStr);//"1"
            }
            if (node.left != null) {
                stack.push(node.left);//2
                stackS.push(curStr);//"1"
            }
            if (node.left == null && node.right == null) {
                res.add(curStr);//[1->3]
            }
        }

        return res;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "abc";
        list.add(str);
        str = "123";

        for(String it : list) {
            System.out.println(it);
        }
    }
}
