package array.hard;

public class _4_Median_of_Two_Sorted_Arrays {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int size = A.length + B.length;
        if (size % 2 == 1)
            return findkth(A, 0, B, 0, size/2 + 1);
        else {
            int first = findkth(A, 0, B, 0, size/2);
            int second = findkth(A, 0, B, 0, size / 2 + 1);
            return (double)(first + second) / 2;
        }
    }

    /**
     * The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B
     */
    private int findkth(int[] a, int starta, int[] b, int startb, int k) {
        if (starta > a.length - 1) return b[startb + k - 1];
        if (startb > b.length - 1) return a[starta + k - 1];
        if (k == 1) return Math.min(a[starta], b[startb]);//3
        int midAIn = starta + k/2 - 1;
        int midBIn = startb + k/2 - 1;
        int midA = Integer.MAX_VALUE, midB = Integer.MAX_VALUE;
        if (midAIn <= a.length - 1) midA = a[midAIn];
        if (midBIn <= b.length - 1) midB = b[midBIn];
        if (midA > midB)
            return findkth(a, starta, b, midBIn + 1, k - k / 2);
        else
            return findkth(a, midAIn + 1, b, startb, k - k /2);
    }

}
