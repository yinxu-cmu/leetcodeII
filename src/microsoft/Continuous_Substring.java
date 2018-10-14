package microsoft;


import java.util.ArrayList;
import java.util.List;

public class Continuous_Substring {
    /**
     * contiguous substring
     *  给字符串 BCCDEG expectation 是 {'BC', 'CD', 'CDE', 'DE'}
     */

    public static List<String> contSub(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[j-1] == 1) {
                    cnt++;
                    res.add(s.substring(i, i + cnt+1));
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (String s : contSub("BCCDEG")) {
            System.out.println(s);
        }
    }
}
