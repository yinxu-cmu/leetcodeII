package math.medium;

public class _640_Solve_the_Equation {
    /**
     * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
     *
     * If there is no solution for the equation, return "No solution".
     *
     * If there are infinite solutions for the equation, return "Infinite solutions".
     *
     * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
     *
     * Example 1:
     * Input: "x+5-3+x=6+x-2"
     * Output: "x=2"
     * Example 2:
     * Input: "x=x"
     * Output: "Infinite solutions"
     * Example 3:
     * Input: "2x=x"
     * Output: "x=0"
     * Example 4:
     * Input: "2x+3x-6x=x+2"
     * Output: "x=-1"
     * Example 5:
     * Input: "x=x+2"
     * Output: "No solution"
     */

    /**
     *  傻逼题。
     *  各种边界情况。
     *  按符号，拆成一段. "+x", "-2x", ,,,, parse每一段。
     */
    int total, coe, index;
    public String solveEquation(String e) {
        index = e.indexOf("=");
        int i = 0, j = 0;
        for (; j < e.length(); j++) {
            char ch = e.charAt(j);
            if (j == 0 || j == index + 1) continue;
            if (ch == '+' || ch == '-' || ch == '=') {
                parse(e.substring(i, j), j);
                i = j;
                if (ch == '=') i++;
            }
        }
        parse(e.substring(i, j), j);

        if (coe == 0 && total == 0) return "Infinite solutions";
        if (coe == 0) return "No solution";
        return "x=" + String.valueOf(total / coe);
    }

    private void parse(String s, int pos) {
        int posX = s.indexOf("x");
        int factor = pos <= index ? 1 : -1;

        if (posX == -1) {
            int num = Integer.valueOf(s);
            total += num * factor * (-1);
        } else {
            //x, -x, +x, 2x,-2x,+2x
            String numStr = s.substring(0, posX);
            if (numStr.equals("") || numStr.equals("+")) numStr = "1";
            if (numStr.equals("-")) numStr = "-1";
            int num = Integer.valueOf(numStr);
            coe += num * factor;
        }
    }
}
