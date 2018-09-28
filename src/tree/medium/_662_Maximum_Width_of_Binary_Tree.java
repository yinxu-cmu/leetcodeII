package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _662_Maximum_Width_of_Binary_Tree {
    /**
     * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
     *
     * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
     *
     * Example 1:
     * Input:
     *
     *            1
     *          /   \
     *         3     2
     *        / \     \
     *       5   3     9
     *
     * Output: 4
     * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
     * Example 2:
     * Input:
     *
     *           1
     *          /
     *         3
     *        / \
     *       5   3
     *
     * Output: 2
     * Explanation: The maximum width existing in the third level with the length 2 (5,3).
     * Example 3:
     * Input:
     *
     *           1
     *          / \
     *         3   2
     *        /
     *       5
     *
     * Output: 2
     * Explanation: The maximum width existing in the second level with the length 2 (3,2).
     * Example 4:
     * Input:
     *
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     * Output: 8
     * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
     *
     *
     * Note: Answer will in the range of 32-bit signed integer.
     */

    /**
     * BFS
     * 用个wrapper class 存node的position. index为i的node， left child 是 2 * i, right child 是 2 * i + 1.
     *
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Box> q = new LinkedList<>();
        q.offer(new Box(root, 0));
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Integer start = null, end = null;
            for (int i = 0; i < size; i++) {//3
                Box box = q.poll();
                TreeNode node = box.node;
                if (node != null) {
                    if (start == null) start = box.pos;//0
                    else end = box.pos;//3
                    q.offer(new Box(node.left, box.pos * 2));
                    q.offer(new Box(node.right, box.pos * 2 + 1));
                }
            }
            if (start == null || end == null) max = Math.max(max, 1);
            else max = Math.max((int)end - (int)start + 1, max);
        }
        return max;
    }

    class Box {
        TreeNode node;
        int pos;
        public Box(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
}
