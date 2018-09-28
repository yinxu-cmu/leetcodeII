package array.medium;

import java.util.ArrayList;
import java.util.List;

public class _842_Split_Array_into_Fibonacci_Sequence {
    /**
     * Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
     *
     * Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
     *
     * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
     * F.length >= 3;
     * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
     * Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
     *
     * Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
     *
     * Example 1:
     *
     * Input: "123456579"
     * Output: [123,456,579]
     * Example 2:
     *
     * Input: "11235813"
     * Output: [1,1,2,3,5,8,13]
     * Example 3:
     *
     * Input: "112358130"
     * Output: []
     * Explanation: The task is impossible.
     * Example 4:
     *
     * Input: "0123"
     * Output: []
     * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not valid.
     * Example 5:
     *
     * Input: "1101111"
     * Output: [110, 1, 111]
     * Explanation: The output [11, 0, 11, 11] would also be accepted.
     * Note:
     *
     * 1 <= S.length <= 200
     * S contains only digits.
     */

    /**
     * 先两个loop找出各种个能的num1, num2组合。 然后递归找下一个吻合的数字。
     *
     * 各种傻逼corner case
     * [0123] 01不能按1算
     * int类型溢出
     *
     */
    public List<Integer> splitIntoFibonacci(String S) {
        //每个num最长是S.length/3, 所以从1->S.length /3.
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int len = (int)Math.ceil((double)S.length() / 3);
        for (int i = 1; i <= len; i++) {
            for (int j = 1;j <= len; j++) {
                List<Integer> list = new ArrayList<>();
                String first = S.substring(0, i);//17
                if (first.length() > 1 && first.charAt(0) == '0') break;
                String second = S.substring(i, i + j);//5
                if (second.length() > 1 && second.charAt(0) == '0') break;
                try {
                    list.add(Integer.valueOf(first));
                    list.add(Integer.valueOf(second));
                } catch(Exception e) {
                    break;
                }
                if (helper(S.substring(i+j), list, first, second)) {
                    return list;
                }
            }

        }
        return res;
    }

    private boolean helper(String input, List<Integer> list, String first, String second) {
        Integer one = Integer.valueOf(first);//17
        Integer two = Integer.valueOf(second);//5
        String sum = String.valueOf(one + two);//22
        if (input.indexOf(sum) != 0) return false;
        list.add(one + two);
        if (sum.equals(input)) return true;
        return helper(input.substring(sum.length()), list, second, sum);
    }
}
