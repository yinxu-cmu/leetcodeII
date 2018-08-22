package array.easy;

import java.util.HashSet;

public class _532_K_diff_Pairs_in_an_Array {

    public int findPairs(int[] nums, int k) {
        //INTERESTING!
        //hashset k=2,
        //set[3,1,4,5], set2()
        //3, contains1? +1, contains 5? +1; set2{3}
        //1, contains3? set2contains3? continue;
        //[1,3,1,5,4], 0
        //[1,1,1,2,1], 1
        HashSet<Integer> set1 = new HashSet<>(); //[1,3,5,4]
        HashSet<Integer> set2 = new HashSet<>(); //[1]
        int res = 0;//

        for (int num : nums) {
            if (set1.contains(num) && k == 0) {
                if (!set2.contains(num)) {
                    res++;
                    set2.add(num);
                }
            }
            set1.add(num);
        }

        if (k == 0) {
            return res;
        } else if (k < 0) {
            return res;
        }

        for (int i=0; i < nums.length; i++) {
            if (set1.contains(nums[i] + k) && !set2.contains(nums[i] + k) && !set2.contains(nums[i])) {
                res++;
            }
            if (set1.contains(nums[i] - k) && !set2.contains(nums[i] - k) && !set2.contains(nums[i])) {
                res++;
            }
            set2.add(nums[i]);
        }

        return res;
    }

}
