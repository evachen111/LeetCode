package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums, int idx){
        result.add(new ArrayList<>(re));

        for (int i = idx; i<nums.length; i++){
            if (i>idx && nums[i] == nums[i-1]){    // i>idx !!!
                // makes sure only for idx comes from the for loop, but not from recursion
                continue;
            }
            re.add(nums[i]);
            helper(nums,i+1);
            re.remove(re.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0);
        return result;
    }

    public static void main(String[] args) {


    }
}
