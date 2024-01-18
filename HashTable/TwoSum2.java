package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//1

// problems:
// 1. [3,3] for 6
// 3. [2,4,3] for 6
public class TwoSum2 {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> ht = new HashMap<>();


        // 1 traversal is enough
        for (int i=0; i<nums.length; i++){
            int key = target-nums[i];
            if (ht.containsKey(key)){
                result[0] = i;
                result[1] = ht.get(key); // get value
                break;
            }
            ht.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        for ( int i : twoSum(nums, target)){
            System.out.println(i);
        }
    }
}
