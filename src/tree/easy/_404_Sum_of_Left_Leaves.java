package tree.easy;

public class _404_Sum_of_Left_Leaves {

    /**
     * Find the sum of all left leaves in a given binary tree.
     *
     * Example:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     *
     * 有点难。
     *
     * 1. recursion. 注意 left child 和 right child 在recursion中的处理方式不一样， 第一次见。
     * 2. iterative.
     */

    public int sumOfLeftLeaves(TreeNode root) {
        //sum(node.left) + sum(node.right);
        //if null 0
        //1,2
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        res += sumOfLeftLeaves(root.right);

        return res;
    }
}
