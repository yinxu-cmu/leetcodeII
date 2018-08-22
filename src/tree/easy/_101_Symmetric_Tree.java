package tree.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _101_Symmetric_Tree {

    /**
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * But the following [1,2,2,null,3,null,3] is not:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     *
     * BFS?
     * tree的比较类题目， iterative解法可以一次进queue两个elements.
     */
    public boolean isSymmetricIte(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

    /**
     * 弱逼recursion解法. 关键是把 isSymmetric 的问题转换成 isMirror 的问题。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;

        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

}
