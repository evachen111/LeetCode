package backTracking;

import java.util.ArrayList;
import java.util.List;

//78
public class Subsets{
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] nums, int nSelect, int idx){
        if (re.size() == nSelect){
            result.add(new ArrayList<>(re));
            return;
        }

//        if (idx == nums.length){
//            return;
//        }
        // could be not included

        for (int i = idx; i<nums.length; i++){
            re.add(nums[i]);
            helper(nums,nSelect,i+1);
            re.remove(re.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        for (int i =0; i<=nums.length; i++){
            helper(nums,i,0);
            re.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets sol = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(sol.subsets(nums));
    }
}
