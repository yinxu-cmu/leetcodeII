package string.medium;

import java.util.ArrayList;
import java.util.List;

public class _6_ZigZag_Conversion {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */

    public String convert(String s, int numRows) {
        //CASE: 'AB', 1
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        boolean dirc = false;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(cur).append(s.charAt(i));
            if (numRows > 1) { //ATTN: numRows == 1的特殊情况
                if (cur == 0 || cur == numRows - 1) dirc = !dirc;
                if (dirc) {
                    cur++;
                } else {
                    cur--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(rows.get(i).toString());
        }
        return res.toString();
    }
}
