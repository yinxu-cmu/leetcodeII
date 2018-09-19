package heap.medium;

import java.util.*;

public class _347_Top_K_Frequent_Elements {
    /**
     * 类似题692
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>( (n1, n2) -> {
            //n1 < n2, <0
            int a = map.get(n1);
            int b = map.get(n2);
            return a == b ? n1 - n2 : a - b;
        });
        for (int num : map.keySet()) {
            q.offer(num);
            if (q.size() > k) q.poll();
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(0, q.poll());
        }
        return res;
    }
}
