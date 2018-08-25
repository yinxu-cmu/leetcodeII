package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

public class _447_Number_of_Boomerangs {

    /**
     * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
     *
     * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
     *
     * Example:
     * Input:
     * [[0,0],[1,0],[2,0]]
     *
     * Output:
     * 2
     *
     * Explanation:
     * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
     *
     * 有点难。 细节很多。
     * 优化的细节。
     * O(n^2)
     */

    public int numberOfBoomerangs(int[][] points) {
        //int[i], int[i+1]
        //map(int[][], Integer)
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int[] a = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue; //ATTN. trick.
                int[] b = points[j];
                int dis = getDis(a, b);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Integer val : map.keySet()) {
                int size = map.get(val);
                if (size >= 2) {
                    cnt += size * (size - 1); //排列组合 An2， n * n-1
                }
            }
        }
        return cnt;
    }

    public int getDis(int[] a, int[] b) {
        int x = Math.abs(a[0] - b[0]);
        int y = Math.abs(a[1] - b[1]);

        return x*x + y*y; //ATTN. 计算sqrt浪费资源， 可省略。
    }


}
