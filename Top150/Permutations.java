package Top150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// 46
public class Permutations {
    public static List<List<Integer>> result;
    public static HashSet<Integer> hs; // all integers of nums are unique
    public static void backtracking(List<Integer> li, int[] nums){
        if (li.size() == nums.length){
            result.add(new ArrayList<>(li));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!hs.contains(nums[i])){
                li.add(nums[i]);
                hs.add(nums[i]);
                backtracking(li, nums);
                hs.remove(Integer.valueOf(nums[i]));
                li.remove(li.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        hs = new HashSet<>();
        backtracking(new ArrayList<>(), nums);
        return result;
    }

    public static void main(String[] args) {

    }
}
