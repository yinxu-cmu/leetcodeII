package string.easy;

public class _14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        //"flower"
        //f
        //i = 0
        if (strs == null || strs.length == 0) {
            return "";
        }
        String common = "";
        String base = strs[0];
        for (int i = 0; i < base.length(); i++) {
            char cur = base.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != cur) { //ATTN:别忘了 check strs[j] 的 length
                    return common;
                }
            }
            common += cur;
        }
        return common;
    }
}
