package array.easy;

public class _665_Non_decreasing_Array {

    public boolean checkPossibility(int[] nums) {
        //case 1: 1, 3, 4, 1, 3
        //case 2: 4,2,3
        //2,3,1
        //case 3: [-1,4,2,3]
        //greedy？ 每scan到一个元素，只考虑保证包含这个元素的左侧数组满足要求，类似DP。比较nums[i], nums[i-1], 而不要同时考虑nums[i+1],
        //这样会把问题复杂化。 另外， 在修改元素时遵守上升速度最慢的原则，这样比较容易想。
        int cnt = 0;
        int i = 0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                cnt++;
                if (i-2 < 0 || nums[i] > nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }

        return cnt <= 1;
    }
}
