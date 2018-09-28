package tree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _508_Most_Frequent_Subtree_Sum {
    /**
     * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
     *
     * Examples 1
     * Input:
     *
     *   5
     *  /  \
     * 2   -3
     * return [2, -3, 4], since all the values happen only once, return all of them in any order.
     * Examples 2
     * Input:
     *
     *   5
     *  /  \
     * 2   -5
     * return [2], since 2 happens twice, however -5 only occur once.
     * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
     */

    /**
     * recursion.
     * preorder traversal, add each value to a hashmap.
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        findSum(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int cnt = map.get(key);
            if (cnt > max) {
                max = cnt;
                list.clear();
                list.add(key);
            } else if (cnt == max) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(n -> n).toArray();
    }

    private int findSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = root.val + findSum(root.left, map) + findSum(root.right, map);
        int cnt = map.getOrDefault(sum, 0);
        map.put(sum, cnt + 1);
        return sum;
    }
}
