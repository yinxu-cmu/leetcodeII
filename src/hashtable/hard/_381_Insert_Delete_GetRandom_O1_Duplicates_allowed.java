package hashtable.hard;

import java.util.*;

public class _381_Insert_Delete_GetRandom_O1_Duplicates_allowed {
    /**
     * hashmap<val, list of index>
     * list<val>
     * add; map1,and list
     * remove: map.get index list, remove last, if size == 0, remove pair. list, remove by swap. update map index list, replace last index.
     * random: nextInt(list size)
     *
     * 类似380.
     * 有点难。
     * LinkedHashSet, 一定要用LinkedHashSet才能保证o(1), 具体data structure的实现需要另看。
     */
    Map<Integer, LinkedHashSet<Integer>> map; //如果用ArrayList代替HashSet的话remove特点元素是o(n)
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public _381_Insert_Delete_GetRandom_O1_Duplicates_allowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            //add
            LinkedHashSet<Integer> indexList = map.get(val);//
            indexList.add(list.size());
            list.add(val);
            return false;
        }
        else {
            LinkedHashSet<Integer> indexList = new LinkedHashSet<>();
            indexList.add(list.size());
            map.put(val, indexList);
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastVal = list.get(list.size() - 1);
            LinkedHashSet<Integer> indexList = map.get(val);

            if (lastVal != val) {

                int index = indexList.iterator().next();
                list.set(index, lastVal);
                LinkedHashSet<Integer> lastValIndexList = map.get(lastVal);
                //update lastvalindexlist, remove last index, add new one
                lastValIndexList.remove(list.size() - 1);
                lastValIndexList.add(index);
                indexList.remove(index);
            } else {
                indexList.remove(list.size() - 1);
            }

            if (indexList.size() < 1) {
                map.remove(val);
            }

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

    public static void main(String[] args) {
//        _381_Insert_Delete_GetRandom_O1_Duplicates_allowed sol = new _381_Insert_Delete_GetRandom_O1_Duplicates_allowed();
//        boolean r1 = sol.insert(4);
//        boolean r2 = sol.insert(3);
//        boolean r3 = sol.insert(4);
//        boolean r4 = sol.insert(2);
//        boolean r5 = sol.insert(4);
//        boolean r6 = sol.remove(4);
//        boolean r7 = sol.remove(3);
//        boolean r8 = sol.remove(4);
//        boolean r9 = sol.remove(4);

        //1: 2 3 5
        //9: 0 1
        //list: 9 9 1 1 2 1

        //1: 2 3
        //9: 0
        //list: 9 1 1

        //1:  2 3 5 6
        //list: 9 9 1 1 2 1 1 3


    }
}
