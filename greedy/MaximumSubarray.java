package greedy;


import java.util.Arrays;
import java.util.stream.IntStream;

//53
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
//        int[] help = Arrays.copyOf(nums,nums.length);
//        Arrays.sort(help);
        int sum = 0;
//        int max = help[help.length-1];
        int max = nums[0];

        for (int i = 0; i<nums.length; i++){
            sum+=nums[i];
            if (sum<nums[i]){
                sum = nums[i];
            }
            if (sum>max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        int[] a = {9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8};
        System.out.println(sol.maxSubArray(a));
    }
}
