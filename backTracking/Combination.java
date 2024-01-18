package backTracking;

import java.util.ArrayList;
import java.util.List;

// 77
public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // base case
        if (k == 1){
            for (int i=1; i<=n; i++){
                List<Integer> re = new ArrayList<>();
                re.add(i);
                result.add(re);
            }
            return result;
        }

        for (int i = n; i>=1; i--){
            List<List<Integer>> re = combine(i-1, k-1);
            for (List<Integer> j : re){
                j.add(i);
            }
            result.addAll(re);
        }
        return result;
    }

    public static void main(String[] args) {
        Combination sol = new Combination();
        System.out.println(sol.combine(4,2));
    }
}
