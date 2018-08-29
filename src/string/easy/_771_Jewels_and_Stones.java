package string.easy;

public class _771_Jewels_and_Stones {

    /**
     * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
     *
     * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * Example 1:
     *
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * Example 2:
     *
     * Input: J = "z", S = "ZZ"
     * Output: 0
     * Note:
     *
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     *
     */

    /**
     * 最弱解法。
     * O(n^2)
     * 还可以用hashmap优化一下， 先存J。 再iterate S. O(N)解法。
     */
    public int numJewelsInStones(String J, String S) {
        if (S == null || S.length() == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < J.length(); i++) {
            char jew = J.charAt(i);
            for (int j = 0; j < S.length(); j++) {
                if (jew == S.charAt(j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
