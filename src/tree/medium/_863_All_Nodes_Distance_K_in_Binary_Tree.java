package tree.medium;

import java.util.*;

public class _863_All_Nodes_Distance_K_in_Binary_Tree {
    /**
     * We are given a binary tree (with root node root), a target node, and an integer value K.
     *
     * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
     *
     * Output: [7,4,1]
     *
     * Explanation:
     * The nodes that are a distance 2 from the target node (with value 5)
     * have values 7, 4, and 1.
     *
     *
     *
     * Note that the inputs "root" and "target" are actually TreeNodes.
     * The descriptions of the inputs above are just serializations of these objects.
     *
     *
     * Note:
     *
     * The given tree is non-empty.
     * Each node in the tree has unique values 0 <= node.val <= 500.
     * The target node is a node in the tree.
     * 0 <= K <= 1000.
     */

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        //map, <node, parent>
        //reach to target
        //begin bfs from target, with a queue, visit set, and distance.
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        mapParent(root, map, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> v = new HashSet<>();
        q.offer(target);
        v.add(target);
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                v.add(node);
                if (dis == K) {
                    res.add(node.val);
                } else {
                    if (node.left != null && !v.contains(node.left)) q.offer(node.left);
                    if (node.right!= null && !v.contains(node.right)) q.offer(node.right);
                    if (map.get(node) != null && !v.contains(map.get(node))) q.offer(map.get(node));
                }
            }
            dis++;
        }
        return res;
    }

    private void mapParent(TreeNode cur, Map<TreeNode, TreeNode> map, TreeNode parent) {
        map.put(cur, parent);
        if (cur  == null) return;
        mapParent(cur.left, map, cur);
        mapParent(cur.right, map, cur);
    }
}
