package tree.medium;

public class _776_Split_BST {
    /**
     * Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.
     *
     * Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.
     *
     * You should output the root TreeNode of both subtrees after splitting, in any order.
     *
     * Example 1:
     *
     * Input: root = [4,2,6,1,3,5,7], V = 2
     * Output: [[2,1],[4,3,6,null,null,5,7]]
     * Explanation:
     * Note that root, output[0], and output[1] are TreeNode objects, not arrays.
     *
     * The given tree [4,2,6,1,3,5,7] is represented by the following diagram:
     *
     *           4
     *         /   \
     *       2      6
     *      / \    / \
     *     1   3  5   7
     *
     * while the diagrams for the outputs are:
     *
     *           4
     *         /   \
     *       3      6      and    2
     *             / \           /
     *            5   7         1
     * Note:
     *
     * The size of the BST will not exceed 50.
     * The BST is always valid and each node's value is different.
     */

    /**
     * 递归。
     * 注意return的array按一致的顺序， a[0]为小于等于v的树，a[1]大于v的树。
     */
    public TreeNode[] splitBST(TreeNode root, int v) {
        if (root == null) return new TreeNode[]{null, root};
        if (root.left == null && root.right == null)
            return root.val <= v ? new TreeNode[]{root, null} : new TreeNode[]{null, root};
        if (root.val == v) {
            TreeNode tmp = root.right;
            root.right = null;
            return new TreeNode[]{root, tmp};
        } else if (root.val > v) {
            TreeNode[] res = splitBST(root.left, v);//null, 1
            root.left = res[1];
//            res[0].right = null;
            return new TreeNode[]{res[0], root};
        } else {
            TreeNode[] res = splitBST(root.right,v);
            root.right = res[0];
//            res[0].right = null;
            return new TreeNode[]{root, res[1]};
        }
    }
}
