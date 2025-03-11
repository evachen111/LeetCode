package Top150;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 448
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            res.add(i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            res.remove(Integer.valueOf(nums[i])); // O(n)
//        }
//        return res;

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
