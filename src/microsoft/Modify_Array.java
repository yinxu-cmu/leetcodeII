package microsoft;

import java.util.Arrays;

public class Modify_Array {
    /**
     * Question 1: Write a function which accepts an integer array and its size and modifies the array in the following manner:
     *
     * 1) If the elements of index i and (i+1) are equal then, double the value at index i
     * and replace the element at index (i+1) with 0.
     *
     * 2) If the element at index i is 0, then ignore it.
     *
     * 3) Any number (element in an array) must be modified only once.
     *
     * 4) At the end, shift all the zeros (0s) to the right of the array and remaining
     * nonzeros to the left of the array.
     *
     * Example:
     * Input: 2 2 0 4 0 8 //400408
     * Output: 4 4 8 0 0 0
     *
     * Input: 2 2 0 4 0 2 //400402
     * Output: 4 4 2 0 0 0
     *
     */
    public static int[] modify(int[] arr) {
        if (arr == null || arr.length <= 1) return new int[0];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
            }
        }
//        Arrays.fill(res, 0);
        int cnt = 0;
        for (int num : arr) {
            if (num != 0) {
                res[cnt++] = num;
            }
        }
        return res;
    }

    /**
     * Write a function which accepts an integer array and its size and returns the maximum index difference
     * i.e. (i-j) such that array[i] < array[j] and i < j. If there is no such case, return -1 .
     *
     * Input: 2 0 3 5 6 1
     * Output: 4
     *
     * 2 0 3 2 4
     *
     * There was only one test case given which is mentioned above. But I am providing the below
     * one of the sample cases which is an important thing to be noted. It returns -1 because all the
     * elements after any given element are smaller than it. DO take care of such cases.
     *
     * Input: 9 8 7 6 5
     * Output: -1
     *
     */
    public static int modify2(int[] arr) {
        //DP. two aux arrays
        //dp1[] - min left
        //dp2[] - max right
        //while (i, j)
        // if (dp1[i] < dp2[j]) j++;
        // else i++;
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1,0};
//        int[] res = modify(input);
//        for (int num : res) {
//            System.out.print(num);
//        }

        System.out.println(modify2(input));
    }
}
