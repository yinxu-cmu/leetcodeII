package string.medium;

public class _186_Reverse_Words_in_a_String_II {
    /**
     * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
     *
     * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
     *
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * Could you do it in-place without allocating extra space?
     */

    /**
     * "blue sky"
     * reverse 一次: "yks eulb"
     * 对每一个word reverse: "sky blue"
     *
     * in place
     *
     */
    public static void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        reverse(s, 0, s.length - 1);
        int i = 0;
        for (int j = 0; j < s.length; j++) {
            if (s[j] == ' ') {
                reverse(s, i, j - 1);
                i = j + 1;
            }
        }
        if (i > 0) {
            reverse(s, i, s.length - 1);
        }
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        String s = "the sky is blue";
        char[] ch = s.toCharArray();
        reverseWords(ch);
        System.out.println(new String(ch));
    }


}
