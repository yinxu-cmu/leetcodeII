package string.easy;

import java.util.Stack;

public class _20_Valid_Parentheses {

    /**
     * stack. ASCII.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.empty() || Math.abs(ch - stack.pop()) > 2) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
