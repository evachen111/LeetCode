package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40
public class CombinationSumII {
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
            // skip duplicate candidate 2
//            if ( i > startIdx && candidates[i] == candidates[i - 1] ) {
//                continue;
//            }

            re.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1);
            re.remove(re.size()-1);
            // skip duplicate candidate
            while (i+1< candidates.length && candidates[i+1] == candidates[i]){
                i++;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort the candidates
        Arrays.sort(candidates);
        helper(candidates,target,0);
        return result;
    }

    public static void main(String[] args) {

    }
}
