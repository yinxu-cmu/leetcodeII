package microsoft;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {
    /**
     * The set [1,2,3,...,n] contains a total of n! unique permutations.
     *
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     *
     * Note:
     *
     * Given n will be between 1 and 9 inclusive.
     * Given k will be between 1 and n! inclusive.
     * Example 1:
     *
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     *
     * Input: n = 4, k = 9
     * Output: "2314"
     */

    static int cnt = 0;
    static List<Integer> res = new ArrayList<>();
    public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        List<Integer> curList = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
        dfs(curList, arr, k);
        String s = "";
        for (int num : res) {
            s += num;
        }
        return s;

    }

    public static void dfs(List<Integer> curList, int[] arr, int k) {
        if (curList.size() == arr.length) {
            cnt++;
            if (cnt == k)
                res = new ArrayList<>(curList);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (curList.contains(arr[i])) continue;
                curList.add(arr[i]);
                dfs(curList, arr, k);
                if (res != null) return; //ATTN: ret to save time.
                curList.remove(curList.size() - 1);
            }
        }
    }
}
