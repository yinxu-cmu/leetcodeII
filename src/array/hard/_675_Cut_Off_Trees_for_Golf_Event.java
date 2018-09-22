package array.hard;

import java.util.*;

public class _675_Cut_Off_Trees_for_Golf_Event {
    /**
     * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
     *
     * 0 represents the obstacle can't be reached.
     * 1 represents the ground can be walked through.
     * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
     * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
     *
     * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
     *
     * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
     *
     * Example 1:
     * Input:
     * [
     *  [1,2,3],
     *  [0,0,4],
     *  [7,6,5]
     * ]
     * Output: 6
     * Example 2:
     * Input:
     * [
     *  [1,2,3],
     *  [0,0,0],
     *  [7,6,5]
     * ]
     * Output: -1
     * Example 3:
     * Input:
     * [
     *  [2,3,4],
     *  [0,0,5],
     *  [8,7,6]
     * ]
     * Output: 6
     * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
     * Hint: size of the given matrix will not exceed 50x50.
     */

    public static int cutOffTree(List<List<Integer>> forest) {
        /**
         *
         * HEAP + BFS.
         * BFS 用queue实现， iterative太坑。
         *
         val, x, y
         >1 add to q, q is min q.
         q.pop,
         func calc min step from cur pos to target. bfs? -1 or cnt.
         res += cnt

         [[1,2,3],[0,0,4],[7,6,5]]
         **/
        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> {
            //if n1 < n2, ret < 0;
            return forest.get(n1.x).get(n1.y) - forest.get(n2.x).get(n2.y);
        });
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> list = forest.get(i);
            for (int j = 0; j < list.size(); j++) {
                int val = list.get(j);
                if (val > 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        int res = 0;
        Node cur = new Node(0, 0);
        while (!q.isEmpty()) {
            Node target = q.poll();
            int step = bfs(cur, target, forest);//1+2+3
            if (step == -1) return -1;
            res += step;
            cur = target;

        }
        return res;

    }

    //123   111
    //456   011
    private static int bfs(Node cur, Node target, List<List<Integer>> forest) {
        //-1; if no way
        int row = forest.size();
        int col = forest.get(0).size();
        boolean[][] v = new boolean[row][col];
        Queue<Node> q = new LinkedList<>();
        q.offer(cur);
        int res = 0;//3
        while (!q.isEmpty()) {
            int size = q.size();//8
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.x == target.x && node.y == target.y) return res;
                if (i == size - 1) res++; //ATTN: 注意res++的位置。 放在魂环最后有可能执行不到而出bug。
                if (node.x < 0 || node.x > row - 1 || node.y < 0 || node.y > col - 1
                        || v[node.x][node.y] || forest.get(node.x).get(node.y) == 0) continue;
                v[node.x][node.y] = true;
                q.offer(new Node(node.x - 1, node.y));
                q.offer(new Node(node.x + 1, node.y));
                q.offer(new Node(node.x, node.y - 1));
                q.offer(new Node(node.x, node.y + 1));

            }
        }
        return -1;

    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        input.add(list1);
        input.add(list2);
        int step = cutOffTree(input);
        System.out.println(step);
    }
}
