package Top150;

import java.util.HashMap;

// 1
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
            else{
                map.put(target - nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
