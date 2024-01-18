package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums, int idx){
//        if (idx == nums.length){
//            return;
//        }
        // could be not included
        result.add(new ArrayList<>(re));
        for (int i = idx; i<nums.length; i++){
            re.add(nums[i]);
            helper(nums,i+1);
            re.remove(re.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0);
        return result;
    }

    public static void main(String[] args) {
        Subsets sol = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(sol.subsets(nums));
    }
}
