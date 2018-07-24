package array;

import java.util.Stack;

public class _581_Shortest_Unsorted_Continuous_Subarray {

    public int findUnsortedSubarray(int[] nums) {
        //1.sort
        //2.思想：monotonic stack
        if (nums.length <= 1) {
            return 0;
        }
        int left = nums.length - 1; //
        int right = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                left = Math.min(stack.pop(), left);
                i--;
            }
        }
        stack.clear();
        for(int j = nums.length - 1; j >= 0; j--) {
            if(stack.empty() || nums[j] <= nums[stack.peek()]) {
                stack.push(j);
            } else {
                right = Math.max(right, stack.pop());
                j++;
            }
        }

        return (right > left) ? right - left + 1 : 0;
    }

}
