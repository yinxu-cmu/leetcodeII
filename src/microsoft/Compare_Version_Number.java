package microsoft;

public class Compare_Version_Number {
    /**
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     *
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
     *
     * Example 1:
     *
     * Input: version1 = "0.1", version2 = "1.1"
     * Output: -1
     * Example 2:
     *
     * Input: version1 = "1.0.1", version2 = "1"
     * Output: 1
     * Example 3:
     *
     * Input: version1 = "7.5.2.4", version2 = "7.5.3"
     * Output: -1
     */

    public static int compareVersion(String version1, String version2) {
        //get first num than compare
        String[] v1 = version1.split("\\."); //ATTN
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length); //ATTN
        for (int i = 0; i < len; i++) {
            int v1n = 0, v2n = 0;
            if (i < v1.length) {
                v1n = Integer.valueOf(v1[i]);
            }
            if (i < v2.length) {
                v2n = Integer.valueOf(v2[i]);
            }
            if (v1n > v2n) return 1;
            if (v1n < v2n) return -1;
        }
        return 0;
    }
}
