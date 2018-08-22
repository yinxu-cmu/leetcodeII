package string.easy;

public class _557_Reverse_Words_in_a_String_III {

    /**
     * StringBuilder 有 reverse()
     *
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(rev(words[i]));
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
