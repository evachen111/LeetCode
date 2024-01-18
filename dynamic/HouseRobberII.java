package dynamic;

import binaryTree.TreeNode;

import java.util.Arrays;

//213
//
public class HouseRobberII {
    public int helper(int[] nums){
        // rolling array
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        int res = 0;

        for (int j = 2; j<nums.length; j++){
            res = Math.max(dp[1], dp[0] + nums[j]);
            dp[0] = dp[1];
            dp[1] = res;
        }
        return dp[1];
    }
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)),
                helper(Arrays.copyOfRange(nums,1,nums.length))
        );
    }

    public static void main(String[] args) {
        HouseRobberII sol = new HouseRobberII();
        int[] a = {0};
        System.out.println(sol.rob(a));
    }
}
