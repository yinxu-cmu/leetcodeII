package heap.easy;

import java.util.PriorityQueue;

public class _703_Kth_Largest_Element_in_a_Stream {

    /**
     * 熟悉 Min Heap 和 Max Heap 的JAVA impl
     * Min Heap: PriorityQueue<>
     * Max Heap: PriorityQueue<>(Collections.reverseOrder());  注入一个自定义的comparator
     */
    private PriorityQueue<Integer> minHeap;
    private int k;

    public _703_Kth_Largest_Element_in_a_Stream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for(int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        //min heap, priority queue
        //add
        //maintain size. <k, add(), >=k, compare (peek), > remove head, add; <= dump
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else {
            if (minHeap.peek() < val) {
                minHeap.add(val);
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
