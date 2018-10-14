package array.easy;

public class _38_Count_And_Say {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     *
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
     *
     * Note: Each term of the sequence of integers will be represented as a string.
     */

    public String countAndSay(int n) {
        if(n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i < prev.length()) {
            char curr = prev.charAt(i);
            int j = 0;
            while(i+j < prev.length() && prev.charAt(i+j) == curr) j++;
            str.append(j);
            str.append(curr);
            i += j;
        }
        return str.toString();
    }
}
