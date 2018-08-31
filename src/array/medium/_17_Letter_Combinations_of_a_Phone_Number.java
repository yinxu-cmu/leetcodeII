package array.medium;

import java.util.*;

public class _17_Letter_Combinations_of_a_Phone_Number {

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     *
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     */

    /**
     * 易错题。
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return helper(map, digits);
    }

    //[2,3]
    private List<String> helper(Map<Character, String> map, String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;//'3'
        String dic = map.get(digits.charAt(0));//def
        List<String> list = helper(map, digits.substring(1));//[d,e,f]
        char[] arr = dic.toCharArray();//abc
        for (char ch : arr) {
            if (list.size() > 0) {
                for(String item : list) {//e
                    StringBuilder sb = new StringBuilder(); //ATTN: StringBuilder注意重新init.
                    sb.append(ch);
                    res.add(sb.append(item).toString());//ad,
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                res.add(sb.toString());//def
            }
        }
        return res;
    }

    /**
     * 值得学习的间接recursion写法
     */

    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations1(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }


}
