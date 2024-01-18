package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 47
public class PermutationsII {
    public List<List<Integer>> result = new ArrayList<>();
    public boolean[] used;
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums){
        if (re.size() == nums.length){
            result.add(new ArrayList<>(re));
            return;
        }

        for (int i = 0; i<nums.length; i++){
            if (used[i]){
                continue;
            }

            ////// for duplicates
            // keep one possibility of permutation
            if(i>0 && nums[i] == nums[i-1] && used[i-1]){
                continue;
            }


            used[i] = true;
            re.add(nums[i]);
            helper(nums);
            used[i] = false;
            re.remove(re.size()-1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // sanity check
        if (nums.length == 0){
            return result;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums);
        return result;
    }

    public static void main(String[] args) {
        PermutationsII sol = new PermutationsII();
        int[] a = {1,1,2,1};
        System.out.println(sol.permuteUnique(a));
    }
}
