package array.easy;

public class _414_Third_Maximum_Number {
    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     *
     * Output: 1
     *
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     *
     * Output: 2
     *
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     *
     * Output: 1
     *
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */

    public int thirdMax(int[] nums) {
        //1. duplicate
        //2. negative
        //3. min value
        Integer m1 = null, m2 = null, m3 = null;
        for (Integer num : nums) {
            if (num.equals(m1) || num.equals(m2) || num.equals(m3)) continue;
            if (m1 == null || num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (m2 == null || num < m1 && num > m2) {
                m3 = m2;
                m2 = num;
            } else if (m3 == null || num < m2 && num > m3) {
                m3 = num;
            }

        }
        return m3 == null ? m1 : m3;
    }
}
