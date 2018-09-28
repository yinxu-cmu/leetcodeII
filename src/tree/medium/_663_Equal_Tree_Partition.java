package tree.medium;

import java.util.HashMap;
import java.util.Map;

public class _663_Equal_Tree_Partition {
    /**
     * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
     *
     * Example 1:
     *
     * Input:
     *     5
     *    / \
     *   10 10
     *     /  \
     *    2   3
     *
     * Output: True
     * Explanation:
     *     5
     *    /
     *   10
     *
     * Sum: 15
     *
     *    10
     *   /  \
     *  2    3
     *
     * Sum: 15
     *
     *
     * Example 2:
     *
     * Input:
     *     1
     *    / \
     *   2  10
     *     /  \
     *    2   20
     *
     * Output: False
     * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
     */

    /**
     * 1. 先算真个tree的sum。 再traverse每个节点， 比较left/right child 是否为sum的一半。
     * 2. 优化：把每个节点的sum存进map里， 这样之后比较 left/right child是否为sum一半时就不用再算了。
     */
    public boolean checkEqualTree (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = getsum(root, map);
        if (sum == 0) return map.getOrDefault(sum, 0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
    public int getsum (TreeNode root, Map<Integer, Integer> map){
        if (root == null) return 0;
        int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }


}
