package Grind75;

import java.util.Arrays;
import java.util.stream.IntStream;

// 724
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int right = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i<nums.length; i++){
            right -= nums[i];
            if (left == right){
                return i;
            }
            else{
                left += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
