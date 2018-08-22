package string.easy;

public class _459_Repeated_Substring_Pattern {

    /**
     * 这道题给了我们一个字符串，问其是否能拆成n个重复的子串。
     * 那么既然能拆分成多个子串，那么每个子串的长度肯定不能大于原字符串长度的一半，
     * 那么我们可以从原字符串长度的一半遍历到1，如果当前长度能被总长度整除，
     * 说明可以分成若干个子字符串，我们将这些子字符串拼接起来看跟原字符串是否相等。
     * 如果拆完了都不相等，返回false。
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                int cnt = n / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cnt; j++) {
                    sb.append(s.substring(0, i));
                }

                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * KMP 算法。
     * 但是不太懂 dp[]是怎么算的。。。。。
     *
     * KMP算法中的next数组是找当前位置的最大相同前缀后缀的个数，而这道题维护的一位数组dp[i]表示，
     * 到位置i-1为止的重复字符串的字符个数，不包括被重复的那个字符串，什么意思呢，我们举个例子，
     * 比如"abcabc"的dp数组为[0 0 0 0 1 2 3]，dp数组长度要比原字符串长度多一个。那么我们看最后一个位置数字为3，
     * 就表示重复的字符串的字符数有3个
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPatternBuDong(String s) {
        int i = 1, j = 0, n = s.length();
        int[] dp = new int[n+1];

        //"abab"
        // b == a ?
        // i =1
        // dp[1] = 1;
        //aaba

        while(i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[++i] = ++j;
            } else if (j == 0) {
                ++i;
            } else {
                j = dp[j];
            }
        }

        return dp[n] > 0 && (dp[n] % (n - dp[n]) == 0);
    }
}
