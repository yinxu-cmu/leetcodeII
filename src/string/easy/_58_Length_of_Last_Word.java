package string.easy;

public class _58_Length_of_Last_Word {

    /**
     * easy. lastIndexOf().
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        //" ", "abc"
        return s.trim().length() -1 - s.trim().lastIndexOf(" ");
    }
}
