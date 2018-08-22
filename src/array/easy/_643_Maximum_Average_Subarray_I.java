package array.easy;

public class _643_Maximum_Average_Subarray_I {

    public static double findMaxAverage(int[] nums, int k) {
        /*
        [1,12,-5,-6,50,3]
        [-1]
        以每一个数为起点计算长度为k的avg
        */
        double max = -Double.MAX_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            double tmp = 0;
            for (int j = i; j < i + k; j++) {
                tmp += nums[j];
            }
            max = Math.max(max, tmp/k);

        }
        return max;
    }

    public double findMaxAverageII(int[] nums, int k) {
        /*
        省掉计算K sum时的重复运算
        */
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum / k;

        for (int i = 1; i + k <= nums.length; i++) {
            double tmp = 0;
            sum = sum - nums[i-1] + nums[i+k-1];
            max = Math.max(max, sum / k);

        }

        return max;


    }
}
