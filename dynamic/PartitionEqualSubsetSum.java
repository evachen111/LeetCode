package dynamic;

import greedy.PartitionLabels;

import java.util.Arrays;

// 416
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2 != 0){
            return false;
        }
        Arrays.sort(nums);
        int[] helper = new int[sum/2+1];
        for (int i = 0; i<nums.length-1; i++){
            for (int j = helper.length-1; j-nums[i]>=0; j--){
                helper[j] = Math.max(helper[j], helper[j-nums[i]]+nums[i]);
            }
            if (helper[sum/2] == sum/2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum sol = new PartitionEqualSubsetSum();
        int[] a = {1,5,11,5};
        System.out.println(sol.canPartition(a));
    }
}
