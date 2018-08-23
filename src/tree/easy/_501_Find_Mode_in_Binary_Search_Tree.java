package tree.easy;

import java.util.*;

public class _501_Find_Mode_in_Binary_Search_Tree {

    /**
     * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
     *
     * Assume a BST is defined as follows:
     *
     * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
     * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
     * Both the left and right subtrees must also be binary search trees.
     *
     *
     * For example:
     * Given BST [1,null,2,2],
     *
     *    1
     *     \
     *      2
     *     /
     *    2
     *
     *
     * return [2].
     *
     * Note: If a tree has more than one mode, you can return them in any order.
     *
     * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
     *
     *
     *
     *
     */

    /**
     * 弱逼解法。 traver tree 然后用一个map存每个val的出现频率， 最后再打出最高频率的所有key。
     */
    public int[] findMode(TreeNode root) {
        //traversal
        //int max;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = traverse(root, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                res.add(entry.getKey());
            }
        }

        return res.stream().mapToInt(i->i).toArray(); //java 8 stream function.
    }

    private int traverse(TreeNode root, HashMap<Integer,Integer> map) {
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            int cnt = map.getOrDefault(node.val, 0) + 1;
            map.put(node.val, cnt);
            if (cnt > max) max = cnt;
            stack.push(node.right);
            stack.push(node.left);
        }

        return max;

    }

    /**
     * O（1）space的解法。
     * 利用binary search tree的性质， 如果做inorder traversal的话每个 val 是排好序的。只需记录一下previous val, 然后和当前val比较，
     * 计算出相当val的count。省掉了 hashmap 保存所有val的count.
     *
     */
    int max = 0;
    int prev = 0;
    int cnt = 0;
    List<Integer> res = new ArrayList<>();

    public int[] findModeO1(TreeNode root) {
        //traversal
        traverse(root);
        return res.stream().mapToInt(i->i).toArray();
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        if (root.val == prev) {
            cnt++;
        } else {
            cnt = 1;
        }
        if (cnt == max) {
            res.add(root.val);
        } else if (cnt > max) {
            res.clear();
            res.add(root.val);
            max = cnt;
        }
        prev = root.val;
        traverse(root.right);
    }
}
