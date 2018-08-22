package greedy.easy;

import java.util.Arrays;

public class _455_Assign_Cookies {

    /**
     * GREEDY.
     */
    public int findContentChildren(int[] g, int[] s) {
        //find the minimum cookie for each child.
        //[1,1], [1,2,3]
        //sort, set negative
        int cnt = 0;
        Arrays.sort(s);
        for (int child: g) {
            for (int i = 0; i < s.length; i++) {//
                if(child <= s[i]) {
                    cnt++;//2
                    s[i] = -s[i];//-1,-2,3
                    break;
                }
            }
        }
        return cnt;
    }
}
