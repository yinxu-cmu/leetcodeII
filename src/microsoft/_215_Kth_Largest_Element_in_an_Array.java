package microsoft;

import java.util.PriorityQueue;

public class _215_Kth_Largest_Element_in_an_Array {

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */

    public int findKthLargest(int[] nums, int k) {
        /**
         * min heap.
         * add nums to heap of size k.
         * return peek.
         *
         * time: O(nlgn)
         */
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            if (q.size() < k) {
                q.offer(num);
            } else {
                if (num > q.peek()) {
                    q.poll();
                    q.offer(num);
                }
            }
        }
        return q.peek();

    }
}
