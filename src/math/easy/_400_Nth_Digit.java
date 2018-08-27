package math.easy;

public class _400_Nth_Digit {

    /**
     * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
     *
     * Note:
     * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
     *
     * Example 1:
     *
     * Input:
     * 3
     *
     * Output:
     * 3
     * Example 2:
     *
     * Input:
     * 11
     *
     * Output:
     * 0
     *
     * Explanation:
     * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
     *
     *
     * 垃圾题。细心就行了？
     */

    public int findNthDigit(int n) {
        //9,90,900, 9000...
        int cnt = 0;
        int i = 0;
        int pre = 0;
        if (n < 10) {
            return n;
        }
        while (cnt < n) {//13
            pre = cnt;//9
            cnt += 9 * Math.pow(10, i) * (i+1);//189
            i++;//2
        }

        //10
        //num of digits: i
        int start = (int) Math.pow(10, i-1);//10
        int index = (n - pre) / i; //nth number in 10:99, 0-index ;2
        int nth = (n - pre) % i; //1-index, 1
        int target = 0;
        if (nth == 0) {
            //target's last digit
            target = start + index - 1;
            // return target % 10;
        } else {
            target = start + index;
            //goal: 10 1st digit
            //10, i - 1 = 2 - 1 = 1
            for (int j = 0; j < i-nth; j++) {
                target = target / 10;
            }
        }

        return target % 10;
    }
}
