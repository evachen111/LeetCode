package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> result = new ArrayList<>();
    public Set<Integer> used = new HashSet<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums){
        if (used.size() == nums.length){
            // elements in set does NOT have a particular order
//            result.add(new ArrayList<>(used));
            result.add(new ArrayList<>(re));
            return;
        }

        for (int i = 0; i<nums.length; i++){
            if (used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            re.add(nums[i]);
            helper(nums);
            used.remove(nums[i]);
            re.remove(re.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        helper(nums);
        return result;
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();
        int[] a = {1,2,3};
        System.out.println(sol.permute(a));

    }
}
