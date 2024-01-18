package backTracking;

import java.util.*;

// 491
public class NonDecreasingSubsequences {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums, int idx){
        if (re.size()>1){
            result.add(new ArrayList<>(re));
        }
//        if (idx == nums.length){
//            return;
//        }

        // a for loop for a layer
        // a set for each layer
        // --> set before each for loop
        Set<Integer> used = new HashSet<>();
        for(int i = idx; i<nums.length; i++){
            if (!re.isEmpty() && nums[i]< re.get(re.size()-1)){
                continue;
            }
            if (i > idx && (nums[i] == nums[i-1] || used.contains(nums[i]))){
                continue;
            }
            re.add(nums[i]);
            used.add(nums[i]);
            helper(nums, i+1);
            re.remove(re.size()-1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums,0);
        return result;
    }

    public static void main(String[] args) {
        NonDecreasingSubsequences sol = new NonDecreasingSubsequences();
        int[] a = {1,2,3,4,1,1,1,1,1};
        System.out.println(sol.findSubsequences(a));
    }
}
