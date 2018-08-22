package binarysearch.easy;

public class _278_First_Bad_Version {

    /**
     * 很基本的bs题目
     *
     * 1.  The formal way is to prove by induction, which you can read up yourself if you are interested.
     * Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview.
     * We just need to test an input of size 2. Check if it reduces the search space to a single element
     * (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.
     *
     * 2. use left + (right - left)/2 to avoid overflow.
     */
    public int firstBadVersion(int n) {
        int i = 1; //1
        int j = n;//2
        while (i < j) {
            int mid  = i + (j - i) / 2; //mid = 1
            if (isBadVersion(mid)) { //true
                j = mid; //1
            } else {
                i = mid + 1;
            }
        }
        return j;
    }

    private boolean isBadVersion(int v) {
        return false;
    }
}
