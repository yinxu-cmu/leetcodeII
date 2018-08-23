package tree.easy;

public class _437_Path_Sum_III {
    /**
     * You are given a binary tree in which each node contains an integer value.
     *
     * Find the number of paths that sum to a given value.
     *
     * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     *
     * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
     *
     * Example:
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Return 3. The paths that sum to 8 are:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3. -3 -> 11
     *
     * 易错题. path是不能中断的， 所以下面的recursion不work。另外还要考虑到node自己构成一条path的情况.
     * recursion.
     *
     */

    public int pathSum(TreeNode root, int sum) {
        //8
        //2
        int cnt = 0;
        if (root == null) return 0;
        if (sum == root.val) cnt++;
        return cnt + pathSum(root.left, sum) + pathSumRoot(root.left, sum - root.val)
                + pathSum(root.right, sum) + pathSumRoot(root.right, sum - root.val); //0+0+(2,10)+(2,2)
    }

    private int pathSumRoot(TreeNode root, int sum) {
        int cnt = 0;
        if (root == null) return 0;
        if (root.val == sum) cnt++;
        return cnt + pathSumRoot(root.left, sum - root.val) + pathSumRoot(root.right, sum - root.val);
    }

}
