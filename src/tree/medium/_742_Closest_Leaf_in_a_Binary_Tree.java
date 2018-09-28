package tree.medium;

import java.util.*;

public class _742_Closest_Leaf_in_a_Binary_Tree {
    /**
     * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.
     *
     * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.
     *
     * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
     *
     * Example 1:
     *
     * Input:
     * root = [1, 3, 2], k = 1
     * Diagram of binary tree:
     *           1
     *          / \
     *         3   2
     *
     * Output: 2 (or 3)
     *
     * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
     *
     *
     * Example 2:
     *
     * Input:
     * root = [1], k = 1
     * Output: 1
     *
     * Explanation: The nearest leaf node is the root node itself.
     *
     *
     * Example 3:
     *
     * Input:
     * root = [1,2,3,4,null,null,null,5,null,6], k = 2
     * Diagram of binary tree:
     *              1
     *             / \
     *            2   3
     *           /
     *          4
     *         /
     *        5
     *       /
     *      6
     *
     * Output: 3
     * Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
     *
     *
     * Note:
     *
     * root represents a binary tree with at least 1 node and at most 1000 nodes.
     * Every node has a unique node.val in range [1, 1000].
     * There exists some node in the given binary tree for which node.val == k.
     */

    /**
     * 这道题让我们找二叉树中最近的叶结点，叶结点就是最底端没有子结点的那个。我们观察题目中的例子3，发现结点2的最近叶结点是其右边的那个结点3，那么传统
     * 的二叉树的遍历只能去找其子结点中的叶结点，像这种同一层水平的结点该怎么弄呢？我们知道树的本质就是一种无向图，但是树只提供了父结点到子结点的连接，
     * 反过来就不行了，所以只要我们建立了反向连接，就可以用BFS来找最近的叶结点了。明白了这一点后，我们就先来做反向连接吧，用一个哈希map，建立子结点与其
     * 父结点之间的映射，其实我们不用做完所有的反向连接，而是做到要求的结点k就行了，因为结点k的子结点可以直接访问，不需要再反过来查找。我们用DFS来遍历
     * 结点，并做反向连接，直到遇到结点k时，将其返回。此时我们得到了结点k，并且做好了结点k上面所有结点的反向连接，那么就可以用BFS来找最近的叶结点了，将
     * 结点k加入队列queue和已访问集合visited中，然后开始循环，每次取出队首元素，如果是叶结点，说明已经找到了最近叶结点，直接返回；如果左子结点存在，并
     * 且不在visited集合中，那么先将其加入集合，然后再加入队列，同理，如果右子结点存在，并且不在visited集合中，那么先将其加入集合，然后再加入队列；再
     * 来看其父结点，如果不在visited集合中，那么先将其加入集合，然后再加入队列。因为题目中说了一定会有结点k，所以在循环内部就可以直接返回了，不会有退出
     * 循环的可能，但是为表尊重，我们最后还是加上return -1吧， 参见代码如下
     *
     * Tree的反向搜索问题， DFS+HashMap
     * Tree的BFS search 实现, Queue + hashset
     */

    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = find(root, null, k, map);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> v = new HashSet<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            v.add(node);
            if (node.left == null && node.right == null) return node.val;
            if (node.left != null && !v.contains(node.left)) q.offer(node.left);
            if (node.right != null && !v.contains(node.right)) q.offer(node.right);
            if (map.get(node) != null && !v.contains(map.get(node))) q.offer(map.get(node));
        }
        return -1;
    }

    private TreeNode find(TreeNode cur, TreeNode parent, int k, Map<TreeNode, TreeNode> map) {
        if (cur == null) return null;
        map.put(cur, parent);
        if (cur.val == k) {
            return cur;
        } else {
            TreeNode left = find(cur.left, cur, k, map);
            TreeNode right = find(cur.right, cur, k, map);
            if (left == null && right == null) return null;
            return left == null ? right : left;
        }
    }

}
