package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _698_Degree_of_an_Array {

    public int findShortestSubArray(int[] nums) {
        /*
        [1,2,2,3,1]
        [1,2,2,3,1,4,2]
        */
        Map<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0;
        for (int i=0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
            degree = Math.max(degree, map.get(nums[i]).size());
        }
        //(1->0,4),(2->1,2,6),
        int len = nums.length;
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == degree) {
                degree = list.size();
                len = Math.min(len, list.get(degree - 1) - list.get(0) + 1);
            }
        }

        return len;
    }
}
