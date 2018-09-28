package string.medium;

public class _537_Complex_Number_Multiplication {
    /**
     * Given two strings representing two complex numbers.
     *
     * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
     *
     * Example 1:
     * Input: "1+1i", "1+1i"
     * Output: "0+2i"
     * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
     * Example 2:
     * Input: "1+-1i", "1+-1i"
     * Output: "0+-2i"
     * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
     * Note:
     *
     * The input strings will not have extra blank.
     * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
     */

    /**
     * Regex 的使用。
     */
    public String complexNumberMultiply(String a, String b) {
        //1+-2i
        String[] x = a.split("\\+|i");
        String[] y = b.split("\\+|i");
        int c1 = Integer.valueOf(x[0]);
        int d1 = Integer.valueOf(x[1]);
        int c2 = Integer.valueOf(y[0]);
        int d2 = Integer.valueOf(y[1]);
        return c1 * c2 + (d1 * d2 * (-1)) + "+" + String.valueOf(c1 * d2 + c2 * d1) + "i";
    }
}
