package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum1 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // sanity check
        if (nums.length < 4){
            return result;
        }

        Arrays.sort(nums);
        // 2 for loops
        for (int i = 0; i<nums.length;i++){
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j<nums.length;j++){
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                // 2 pointers
                int left = j+1;
                int right = nums.length - 1;

                while(left<right){
                    int value = nums[i] + nums[j] + nums[left] + nums[right];
                    if (value > target){
                        right--;
                    }
                    else if (value < target){
                        left++;
                    }
                    else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        while (left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
