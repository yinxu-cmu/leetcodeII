package string.easy;

public class _67_Add_Binary {

    /**
     * 1. convert char to int 的牛逼方法: a.charAt(i) - '0';
     * 2. stringbuilder.reverse()
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (sum % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }

            if (sum / 2 == 1) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        //ATTN: 别忘了最后检查进位
        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();

    }
}
