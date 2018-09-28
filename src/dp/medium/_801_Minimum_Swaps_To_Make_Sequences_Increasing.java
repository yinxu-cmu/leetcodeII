package dp.medium;

public class _801_Minimum_Swaps_To_Make_Sequences_Increasing {
    /**
     * We have two integer sequences A and B of the same non-zero length.
     *
     * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
     *
     * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
     *
     * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
     *
     * Example:
     * Input: A = [1,3,5,4], B = [1,2,3,7]
     * Output: 1
     * Explanation:
     * Swap A[3] and B[3].  Then the sequences are:
     * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
     * which are both strictly increasing.
     * Note:
     *
     * A, B are arrays with the same length, and that length will be in the range [1, 1000].
     * A[i], B[i] are integer values in the range [0, 2000].
     */

    /**
     * 这道题给了我们两个长度相等的数组A和B，说是可以在任意位置i交换A[i]和B[i]的值，我们的目标是让数组A和B变成严格递增的数组，
     * 让我们求出最少需要交换的次数。博主最先尝试了贪婪算法，就是遍历数组，如果当前数字小于等于前面一个数字，那么就交换一下，但是问题就来了
     * ，到底是交换当前位置的数字，还是前一个位置的数字呢，比如下面这个例子：
     *
     * 0   4   4   5
     *
     * 0   1   6   8
     *
     * 我们到底是交换4和1呢，还是4和6呢，虽然两种方法都能让前三个数字严格递增，但是如果交换了4和6，那么第一个数组的最后一个5就又得交换了，
     * 那么就要多交换一次，所以这个例子是交换4和1，但是对于下面这个例子：
     *
     * 0   4   4   7
     *
     * 0   1   6   5
     *
     * 那么此时我们就要交换4和6了，这样只要交换一次就能使两个数组都变成严格递增的数组了。所以这道题用贪婪算法不work，我们必须使用别的方法，
     * 那么此时动态规划Dynamic Programming就闪亮登场了。
     *
     * 像这种求极值的题目，不是Greedy就是DP啊，一般难题偏DP的比较多。而DP解法的第一步就是要确定dp数组该怎么定义，如果我们定义一个一维数组dp，
     * 其中dp[i]表示使得范围[0, i]的子数组同时严格递增的最小交换次数，这样的话状态转移方程就会十分的难写，因为我们没有解耦合其内在的关联。
     * 当前位置i是否交换，只取决于和前面一位是否是严格递增的，而前一位也有交换或者不交换两种状态，那么前一位的不同状态也会影响到当前是否交换，
     * 这跟之前那道Best Time to Buy and Sell Stock with Transaction Fee就十分到类似了，那道题的股票也有保留或者卖出两种状态不停的切换。
     * 那么这里我们也需要维护两种状态，swap和noSwap，那么swap[i]表示范围[0, i]的子数组同时严格递增且当前位置i需要交换的最小交换次数，
     * noSwap[i]表示范围[0, i]的子数组同时严格递增且当前位置i不交换的最小交换次数，两个数组里的值都初始化为n。由于需要跟前一个数字比较，
     * 所以我们从第二个数字开始遍历，那么就需要给swap和noSwap数组的第一个数字提前赋值，swap[0]赋值为1，因为其表示i位置需要交换，noSwap[0]赋值为0，
     * 因为其表示i位置不需要交换。
     *
     * 好，下面来分析最难的部分，状态转移方程。由于这道题限制了一定能通过交换生成两个同时严格递增的数组，那么两个数组当前位置和前一个位置之间的关系只有两种，
     * 一种是不用交换，当前位置的数字已经分别大于前一个位置，另一种是需要交换后，当前位置的数字才能分别大于前一个数字。那么我们来分别分析一下，
     * 如果当前位置已经分别大于前一位置的数了，那么讲道理我们是不需要再进行交换的，但是swap[i]限定了我们必须要交换当前位置i，那么既然当前位置要交换，
     * 那么前一个位置i-1也要交换，同时交换才能继续保证同时递增，这样我们的swap[i]就可以赋值为swap[i-1] + 1了。而noSwap[i]直接赋值为noSwap[i-1]即可，
     * 因为不需要交换了。第二种情况是需要交换当前位置，才能保证递增。那么swap[i]正好也是要交换当前位置，而前一个位置不能交换，
     * 那么即可以用noSwap[i-1] + 1来更新swap[i]，而noSwap[i]是不能交换当前位置，那么我们可以通过交换前一个位置来同样实现递增，
     * 即可以用swap[i-1]来更新noSwap[i]，当循环结束后，我们在swap[n-1]和noSwap[n-1]中返回较小值即可，参见代码如下：
     *
     */
    public int minSwap(int[] A, int[] B) {
        int[] swap = new int[A.length];
        int[] noswap = new int[A.length];
        swap[0] = 1;
        noswap[0] = 0;
        for (int i = 1; i < A.length; i++) {
            swap[i] = A.length;
            noswap[i] = A.length;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                swap[i] = swap[i - 1] + 1;
                noswap[i] = noswap[i - 1];
            }
            if (A[i] > B[i - 1] && B[i] > A[i -1]) {
                swap[i] = Math.min(swap[i], noswap[i - 1] + 1);
                noswap[i] = Math.min(noswap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[A.length - 1], noswap[A.length - 1]);
    }
}
