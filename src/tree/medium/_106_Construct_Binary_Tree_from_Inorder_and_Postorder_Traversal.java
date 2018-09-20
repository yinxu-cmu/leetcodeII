package tree.medium;

import java.util.Arrays;

public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * inorder = [9,3,15,20,7]
     * postorder = [9,15,7,20,3]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */

    /**
     *
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int size = postorder.length;
        if (size == 1) return new TreeNode(inorder[0]);
        if (size == 0) return null;
        int rootVal = postorder[size - 1];
        TreeNode node = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = 0; i < size; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);

        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, size);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, size - 1);

        node.left = buildTree(leftInorder, leftPostorder);
        node.right = buildTree(rightInorder, rightPostorder);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}
