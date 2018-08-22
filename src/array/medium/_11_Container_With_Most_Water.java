package array.medium;

public class _11_Container_With_Most_Water {

    //brute force. O(n^2)
    public int maxArea(int[] height) {
        // int[] dp = new int[height.length];
        // dp[0] = 0;
        int max = 0;
        for (int i=1; i < height.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                int width = i - j;
                int tall = Math.min(height[i], height[j]);
                max = Math.max(max, width * tall);
            }
        }

        return max;
    }

    //two pointers. 最大面积由两个边中较短的那个决定， 所以两个pointer中，缩进其中较短的那个， 以保证较高的边且有较大的宽度。 趋势的思想。
    public int maxAreaOptimize(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left  < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, w * h);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
