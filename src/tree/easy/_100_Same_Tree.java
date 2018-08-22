package tree.easy;

public class _100_Same_Tree {

    /**
     * 弱逼recursion解法
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //root same
        //left, right same
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
