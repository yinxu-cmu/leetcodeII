package string.easy;

public class _387_First_Unique_Character_in_a_String {

    /**
     * 26 长度的array存每个char的出现频率
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int index = s.length();
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 1) {
                char ch = (char)(i + (int)'a');
                index = s.indexOf(ch) < index ? s.indexOf(ch) : index;
            }
        }
        return index == s.length() ? -1 : index;
    }
}
