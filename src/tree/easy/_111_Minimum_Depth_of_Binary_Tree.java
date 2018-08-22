package tree.easy;

public class _111_Minimum_Depth_of_Binary_Tree {

    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its minimum depth = 2.
     */

    public int minDepth(TreeNode root) {
        //null 0
        //min(min(left), min(right)) + 1;
        //[1,2]
        if (root == null) return 0;
        int lm = minDepth(root.left);
        int rm = minDepth(root.right);

        if (lm == 0) return rm + 1; //注意有一侧subtree为null的情况
        if (rm == 0) return lm + 1;

        return Math.min(lm, rm) + 1;
    }
}
