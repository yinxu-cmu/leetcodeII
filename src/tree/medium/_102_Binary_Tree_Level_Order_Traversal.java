package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102_Binary_Tree_Level_Order_Traversal {
    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its level order traversal as:
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */

    /**
     * BFS
     * queue add head
     * while (!emp)
     *   int size
     *   new list
     *   loop size
     *     both children add to q
     *     list.add(val)
     *   list -> array
     *   add to res.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();//[3] [9,20]
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();//15, 7
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();//2
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();//20
                list.add(node.val);//[9,20]
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
