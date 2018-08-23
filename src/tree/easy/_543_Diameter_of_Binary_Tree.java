package tree.easy;

public class _543_Diameter_of_Binary_Tree {

    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.
     *
     * 比较每一个node可以形成的最长diameter， 包含左右。 取max。
     * 在计算每一个node的最长diameter时，注意递归函数返回的是最长diameter，所以是单侧的。
     */

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterRoot(root);
        return max;
    }
    //1,2
    private int diameterRoot(TreeNode node) {
        if (node == null) return 0;
        int left = 0, right = 0;
        if (node.left != null) {
            left = 1 + diameterRoot(node.left);
        }
        if (node.right != null) {
            right = 1 + diameterRoot(node.right);
        }
        max = max > (left + right) ? max : (left + right); //包含左右

        return Math.max(left, right); //在计算每一个node的最长diameter时，注意递归函数返回的是最长diameter，所以是单侧的。
    }
}
