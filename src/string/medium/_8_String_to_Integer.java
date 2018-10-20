package string.medium;

public class _8_String_to_Integer {
    /**
     * special case: " ", " 41", overflow.
     */
    public static int myAtoi(String str) {
        //0
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        //sign
        int start = 0;
        int sign = 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '+' ? 1 : -1;
            start++;
        }
        long total = 0;
        for (int i = start; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;
            total = total * 10 + digit;
            if (total > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return sign * (int) total;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-41"));
    }
}
