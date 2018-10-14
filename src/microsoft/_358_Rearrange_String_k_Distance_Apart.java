package microsoft;

import java.util.*;

public class _358_Rearrange_String_k_Distance_Apart {
    /**
     * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
     *
     * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
     *
     * Example 1:
     * s = "aabbcc", k = 3
     *
     * Result: "abcabc"
     *
     * The same letters are at least distance 3 from each other.
     * Example 2:
     * s = "aaabc", k = 3
     *
     * Answer: ""
     *
     * It is not possible to rearrange the string.
     * Example 3:
     * s = "aaadbbcc", k = 2
     *
     * Answer: "abacabcd"
     *
     * Another possible answer is: "abcabcda"
     *
     * The same letters are at least distance 2 from each other.
     */

    public String rearrangeString(String str, int k) {

        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        PriorityQueue<Map.Entry> maxHeap = new PriorityQueue<>(
                (Map.Entry entry1, Map.Entry entry2) -> {
                return (int)entry2.getValue() - (int)entry1.getValue();
            }
        );

        Queue<Map.Entry> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Map.Entry current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue((int)current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // intial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if ((int)front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == str.length() ? rearranged.toString() : "";
    }
}
