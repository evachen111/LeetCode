package binaryTree;

import java.util.Arrays;

public class MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //sanity check
        if (nums.length == 0){
            return null;
        }
        // find the max
        int idx = 0;
        int max = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx+1, nums.length));
        return root;
    }

    public static void main(String[] args) {

        int[] a = {59,51,34,17,42,65,67,102,77,69,101,95,54,97,105,86,69,15,45,138,88,131,102,30,43,42,18,21,69,38,37,33,46,19,29,15,38,141,109,23,134,20,147,57,86,112,138,137,78,112,61,61,130,60,130,24,5,73,65,100,123,128,119,62,67,102,78,123,62,90,107,122};
        System.out.println(a.length);
        Arrays.sort(a);
        for (int i  = 0; i<a.length; i++){
            if (a[i] == 88){
                System.out.println(i);
            }
        }
        System.out.println(a[0]);
    }
}
