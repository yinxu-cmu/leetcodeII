package tree.easy;

import java.util.Arrays;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

    /**
     *
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     *  易错题. 注意mid的计算方式
     *
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //find mid, node
        //node.left = bst(left); node.right = bst(right);
        if(nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length % 2 == 0 ? (nums.length/2)-1 : nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));

        return root;
    }
}
