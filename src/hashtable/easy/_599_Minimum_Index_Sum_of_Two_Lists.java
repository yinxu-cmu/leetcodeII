package hashtable.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599_Minimum_Index_Sum_of_Two_Lists {

    /**
     * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
     *
     * You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
     *
     * Example 1:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * Output: ["Shogun"]
     * Explanation: The only restaurant they both like is "Shogun".
     * Example 2:
     * Input:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * Output: ["Shogun"]
     * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
     * Note:
     * The length of both lists will be in the range of [1, 1000].
     * The length of strings in both lists will be in the range of [1, 30].
     * The index is starting from 0 to the list length minus 1.
     * No duplicates in both lists.
     *
     * 简单。
     */

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> l1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            l1.put(list1[i], i);
        }

        int sum = list1.length + list2.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String str = list2[i];
            if (l1.containsKey(str)) {
                int s = l1.get(str) + i;
                if (s < sum) {
                    sum = s;
                    res.clear();
                    res.add(str);
                } else if (s == sum) {
                    res.add(str);
                }
            }
        }
        return res.stream().toArray(String[]::new);

    }
}
