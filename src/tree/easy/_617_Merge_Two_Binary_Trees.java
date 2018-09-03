package tree.easy;

import java.util.Stack;

public class _617_Merge_Two_Binary_Trees {
    /**
     * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
     *
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
     *
     * Example 1:
     * Input:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * Output:
     * Merged tree:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * Note: The merging process must start from the root nodes of both trees.
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /**
         * both !null, newnode(sum)
         * newnode.left=mt(t1.left, t2.left)
         * newnode.right same
         * if (one null) return the other.
         * if (both null) return null.
         */
        if (t1 == null && t2 == null) return null;
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }

    /**
     * iterative.
     * 有点难.
     * 理清思路：merge t1 到 t2. 然后traversal.
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        /**
         * root
         * stack<[]>, root1, root2
         * while
         *   pop
         *   //n1,n2 both !null
         *   n0.val += n1.val
         *   if(n0.left is null && n1.left !null): continue;
         *   if(n0.left !null && n1.left ==null): n1.left=n0.left;
         *   if(both !null) stack.push([])
         */
        if (t1 == null && t2 == null) return null;
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});//
        while (!stack.empty()) {//[3,4,5,5,4]
            //left -> right
            TreeNode[] n = stack.pop();//[2,3]
            n[1].val += n[0].val;
            if (n[0].right != null && n[1].right == null) {
                n[1].right = n[0].right;
            } else if (n[0].right != null && n[1].right != null) {
                stack.push(new TreeNode[]{n[0].right, n[1].right});
            }

            if (n[0].left != null && n[1].left == null) {
                n[1].left = n[0].left;
            } else if (n[0].left != null && n[1].left != null) {
                stack.push(new TreeNode[]{n[0].left, n[1].left});
            }
        }
        return t2;
    }
}
