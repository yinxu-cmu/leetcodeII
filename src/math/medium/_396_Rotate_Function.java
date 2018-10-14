package math.medium;

public class _396_Rotate_Function {
    /**
     * Given an array of integers A and let n to be its length.
     *
     * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
     *
     * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
     *
     * Calculate the maximum value of F(0), F(1), ..., F(n-1).
     *
     * Note:
     * n is guaranteed to be less than 105.
     *
     * Example:
     *
     * A = [4, 3, 2, 6]
     *
     * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
     * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
     * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
     * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
     *
     * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
     */

    /**
     * 纯数学推倒。 找出F(k)和F(k-1)之间的关系。然后O(n)时间解决。
     * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
     * F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
     *        = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
     * Then,
     *
     * F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
     *               = (Bk[0] + ... + Bk[n-1]) - nBk[0]
     *               = sum - nBk[0]
     * Thus,
     *
     * F(k) = F(k-1) + sum - nBk[0]
     * What is Bk[0]?
     *
     * k = 0; B[0] = A[0];
     * k = 1; B[0] = A[len-1];
     * k = 2; B[0] = A[len-2];
     * ...
     */
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int F = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            F += A[i] * i;
            sum += A[i];
        }
        int max = F;
        for (int j = 1; j < n; j++) {
            F = F + sum - n * A[n-j];
            max = Math.max(max, F);
        }
        return max;
    }
}