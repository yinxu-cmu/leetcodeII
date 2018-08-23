package tree.easy;

public class _538_Convert_BST_to_Greater_Tree {

    /**
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     *
     * Example:
     *
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     *
     * 易错题。
     * 需要注意extra value不要重复计算
     */

    int ex = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        trav(root);
        return root;
    }

    private void trav(TreeNode node) {
        if (node == null) return;
        trav(node.right);
        int val = node.val; //易错
        node.val = val + ex;
        ex += val;
        trav(node.left);
    }
}
