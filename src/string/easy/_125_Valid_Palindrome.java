package string.easy;

import java.util.Stack;


public class _125_Valid_Palindrome {
    /**
     * Use stack to reverse.
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        //reverse
        //1. case
        //2. alphanumeric
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch);
            }
        }
        //compare
        for (int j=0; j < s.length(); j++) {
            if (Character.isLetterOrDigit(s.charAt(j))) {
                if (stack.pop() != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * tow pointers.
     * @param s
     * @return
     */
    public boolean isPalindromeTwoPointers(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        //reverse
        //1. case
        //2. alphanumeric
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char chari = s.charAt(i);
            if (Character.isLetterOrDigit(chari)) {
                chari = Character.toLowerCase(chari);
            } else {
                i++;
                continue;
            }

            char charj = s.charAt(j);
            if (Character.isLetterOrDigit(charj)) {
                charj = Character.toLowerCase(charj);
            } else {
                j--;
                continue;
            }

            if (chari != charj ) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
