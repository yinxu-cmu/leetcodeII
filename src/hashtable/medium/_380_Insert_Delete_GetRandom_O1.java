package hashtable.medium;

import java.util.*;

public class _380_Insert_Delete_GetRandom_O1 {
    /**
     用hashmap 存 val -> val在list中的index
     用list存val， 因为list.get 是o(1).
     trick： list remove不是o(1), 解决办法：swap val所在的位置和 end, remove end是o(1).

     有点意思
     **/
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public _380_Insert_Delete_GetRandom_O1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(index, lastVal);
            map.put(lastVal, index);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
