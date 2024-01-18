package backTracking;

import java.util.ArrayList;
import java.util.List;

// 216

// state: list of integers, and the sum of it
public class CombinationSumIII {
    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> state = new ArrayList<>();

    // reduce the runtime
//    public int sum(List<Integer> nums){
//        return nums.stream().mapToInt(Integer::intValue).sum();
//    }

    public void helper(int k, int n, int min, int sum){
        // base case
//        int s = sum(state);
        if (sum > n){
            return;
        }
        if (state.size() == k &&  sum == n){
            result.add( new ArrayList<>(state)); // deep copy
            return;
        }

        for (int i = min; i<10; i++){
            // 2 states
            state.add(i);
            sum += i;

            helper(k,n,i+1, sum);

            state.remove(state.size()-1);
            sum -= i;
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        // sanity check
        if (n<k){
            return result;
        }
        helper(k,n,1, 0);
        return result;
    }

    public static void main(String[] args) {

        CombinationSumIII sol = new CombinationSumIII();

        sol.state.add(1);
        sol.state.add(12);
        System.out.println(sol.state.get(-1)); // out of range  // get(.size()-1)

    }
}
