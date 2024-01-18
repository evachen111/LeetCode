package dynamic;

import java.util.Arrays;

/// 494
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum<-target){     // consider negative integers
            return 0;
        }
        if ((sum+target)%2 != 0){
            return 0;
        }
        int size = (sum+target)/2;
        // consider negatives
        if (size<0){
            size = -size;
        }
        int[] dp = new int[size+1];
        dp[0]=1;
        for (int i = 0; i<nums.length; i++){
            for (int j = size; j>=nums[i]; j--){
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {

    }
}
