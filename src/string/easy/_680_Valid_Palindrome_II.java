package string.easy;

public class _680_Valid_Palindrome_II {

    /**
     * 建立一个helper function. 重点是当检测到不match的点后， 判断 (i, j-1) 和 （i+1, j)是否为palindrome
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        //two pointers i j
        //(i, j-1) || (i+1, j) pal
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return pali(s.substring(i, j)) || pali(s.substring(i+1, j+1));
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean pali(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
