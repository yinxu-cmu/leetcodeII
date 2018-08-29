package array.hard;

public class _42_Trapping_Rain_Water {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     * Example:
     *
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */

    /**
     * 有点难。需要revisit.
     * 考验编程思想。
     */

    /**
     * O(n^2)解法。 找每一个ele的水。 向左右分别找到maxLeft, maxRight. 确定每一个ele的水量。
     */
    public int trap1(int[] height) {
        if (height == null || height.length < 3) return 0;
        //find water for each ele.
        //for each: find max_left, find max_right. water += min(max_left, max_right) - height[i]
        //boundary: i<0: left=0, i=length, right=0;
        int water = 0;
        for (int i=0; i < height.length; i++) {
            int maxL = 0;
            int maxR = 0;
            for (int left = i - 1; left >=0; left--) {
                maxL = Math.max(maxL, height[left]);
            }
            for (int right = i + 1; right < height.length; right++) {
                maxR = Math.max(maxR, height[right]);
            }
            water += Math.max(0, Math.min(maxL, maxR) - height[i]);
        }
        return water;
    }

    /**
     * DP 解法。
     * O(N) time
     * O(N) Space
     *
     */
    public int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;
        //dp. save tmp max result in int[] maxL, maxR to save time.
        int water = 0;
        int size = height.length;
        int[] maxL = new int[size];
        int[] maxR = new int[size];
        maxL[0] = height[0];
        for (int i = 1; i < size; i++) {
            //left inclusive max left.
            maxL[i] = Math.max(maxL[i-1], height[i]);
        }
        maxR[size-1] = height[size-1];
        for (int j = size - 2;j >= 0; j--) {
            maxR[j] = Math.max(maxR[j+1], height[j]);
        }
        for (int l = 1; l < size - 1; l++) {
            water += Math.min(maxL[l], maxR[l]) - height[l];
        }
        return water;
    }

    /**
     * 最高级解法。
     * two pointers.
     * O(n) time. O(1) space.
     * left = 0, right = size-1;
     * leftmax=0, rightmax=last;
     * 不懂！操！
     */
    public int trap3(int[] height) {
        if (height == null || height.length < 3) return 0;
        int water = 0;

        return 666;
    }


}
