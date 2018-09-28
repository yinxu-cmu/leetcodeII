package array.medium;

public class _775_Global_and_Local_Inversions {
    /**
     *
     * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
     *
     * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
     *
     * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
     *
     * Return true if and only if the number of global inversions is equal to the number of local inversions.
     *
     * Example 1:
     *
     * Input: A = [1,0,2]
     * Output: true
     * Explanation: There is 1 global inversion, and 1 local inversion.
     * Example 2:
     *
     * Input: A = [1,2,0]
     * Output: false
     * Explanation: There are 2 global inversions, and 1 local inversion.
     * Note:
     *
     * A will be a permutation of [0, 1, ..., A.length - 1].
     * A will have length in range [1, 5000].
     * The time limit for this problem has been reduced.
     */

    /**
     * 有点难。
     * 这道题给了一个长度为n的数组，里面是0到n-1数字的任意排序。又定义了两种倒置方法，全局倒置和局部倒置。
     * 其中全局倒置说的是坐标小的值大，局部倒置说的是相邻的两个数，坐标小的值大。那么我们可以发现，
     * 其实局部倒置是全局倒置的一种特殊情况，即局部倒置一定是全局倒置，而全局倒置不一定是局部倒置，
     * 这是解这道题的关键点。题目让我们判断该数组的全局倒置和局部倒置的个数是否相同，那么我们想，什么情况下会不相同？
     * 如果所有的倒置都是局部倒置，那么由于局部倒置一定是全局倒置，则二者个数一定相等。
     * 如果出现某个全局倒置不是局部倒置的情况，那么二者的个数一定不会相等。所以问题的焦点就变成了是否能找出不是局部倒置的全局倒置。
     * 所以为了和局部倒置区别开来，我们不能比较相邻的两个，而是至少要隔一个来比较。我们可以从后往前遍历数组，遍历到第三个数字停止，
     * 然后维护一个 [i, n-1] 范围内的最小值，每次和 A[i - 2] 比较，如果小于 A[i - 2]，说明这是个全局的倒置，并且不是局部倒置，
     * 那么我们直接返回false即可，参见代码如下：
     */
    public boolean isIdealPermutation(int[] A) {
        int size = A.length;
        int min = Integer.MAX_VALUE;
        for (int i = size - 1; i >= 2; i--) {
            min = Math.min(min, A[i]);
            if (A[i-2] > min) return false;
        }
        return true;
    }
}
