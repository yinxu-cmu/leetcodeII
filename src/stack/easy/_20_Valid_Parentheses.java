package stack.easy;

import java.util.Stack;

public class _20_Valid_Parentheses {

    public boolean isValid(String s) {
        //stack<char>,
        //if left, push
        //if right, stack.pop(), diff < 2; good
        //diff > 2 || stack.empty(); bad
        //stack.empty? good
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

        return stack.empty() ? true : false;
    }
}
