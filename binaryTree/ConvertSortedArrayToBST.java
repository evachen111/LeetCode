package binaryTree;

import java.util.Arrays;

// 108
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        int mid = nums[nums.length/2];
        TreeNode root = new TreeNode(mid);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1, nums.length));
        return root;
    }

    public static void main(String[] args) {

    }
}
