package array.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _239_Sliding_Window_Maximum {

    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     *
     * Example:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     *
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     *  87654321
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
     *
     * Follow up:
     * Could you solve it in linear time?
     */


    /**
     * O(n)
     * Monotonic Queue. Amortized O(1) time for add/remove/get.
     * 1. double end. 两侧都可以增减
     * 2. 队列里的元素是递减的. 所以比新增加的元素小的元素都可以删除，因为肯定不是potential最大。
     * get() 返回最大值
     * add() 增加新元素, 同时删除比新元素小的其他所有元素。
     * remove() 删除最大值
     *
     * 有趣的题。
     * https://www.youtube.com/watch?v=2SXqBsTR6a8
     */
    class MonoQueue {
        Deque<Integer> q;

        public MonoQueue() {
            q = new ArrayDeque<>();
        }

        public int get() {
            return q.getFirst();
        }

        //[1,3,1,2,0,5]
        //[3,2,0]
        //3,3
        public void add(int e) {
            while (!q.isEmpty() && q.getLast() < e) {
                q.removeLast();
            }
            q.addLast(e);
        }

        public void remove() {
            q.removeFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * loop:
         *   add each
         *   get for max
         *
         * [1,3,-1,-3,5,3,6,7],3
         *
         */
        if (nums == null || nums.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        MonoQueue q = new MonoQueue();//[1,3]
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
            if (i >= k - 1) {
                res.add(q.get());
                if (q.get() == nums[i-k+1]) {
                    q.remove();
                }
            }
        }
        return res.stream().mapToInt(num -> num).toArray();
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {

        /**
         * n^2 solution
         * i=0, j=k-1
         * while(j < len)
         *   findMax.
         *   i++;
         *   j++;
         */
        if (nums == null || nums.length == 0) return new int[0];
        int i = 0;
        int j = k - 1;
        List<Integer> res = new ArrayList<>();
        while (j < nums.length) {
            int max = nums[i];
            for (int m = i; m <= j; m++) {
                max = max > nums[m] ? max : nums[m];
            }
            res.add(max);
            i++;
            j++;
        }
        return res.stream().mapToInt(num -> num).toArray();
    }

}
