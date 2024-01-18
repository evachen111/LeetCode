package backTracking;

import java.util.ArrayList;
import java.util.List;

// 39
public class CombinationSum {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> re = new ArrayList<>();

    public void helper(int[] candidates, int target, int startIdx){
        //solution
        if (target < 0){
            return;
        }
        if (target == 0){
            result.add( new ArrayList<>(re));
            return;
        }

        for (int i = startIdx; i<candidates.length; i++){
            re.add(candidates[i]);
            helper(candidates, target-candidates[i], i);
            re.remove(re.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0);
        return result;
    }

    public static void main(String[] args) {

        CombinationSum sol = new CombinationSum();
        int[] a = {1,2,3};
        System.out.println(sol.combinationSum(a,3));

    }
}
