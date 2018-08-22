package string.easy;

public class _520_Detect_Capital {

    /**
     * 利用了fact upper case 的 ascii 比 lower case char 的都要小
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if('Z' - c >= 0) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }
}
