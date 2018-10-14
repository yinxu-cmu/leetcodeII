package tree.medium;

public class _285_Inorder_Successor_in_BST {
    /**
     * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
     *
     * Note: If the given node has no in-order successor in the tree, return null.
     *
     */
    TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode t) {
        if (root == null) return null;
        inorderSuccessor(root.left, t);
        if (pre == t) {
            return root;
        } else {
            pre = root;
        }
        inorderSuccessor(root.right, t);
        return null;
    }


}
