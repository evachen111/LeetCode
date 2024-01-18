package HashTable;

import java.lang.reflect.Array;
import java.util.*;

//15
// reduce complexity
//  1.
//      stores all and check if sth exists in the future --->
//      stores clue and left to be checked in the future
//  2.  to check duplicates:
//      using set instead of using list.contains()


public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i<nums.length; i++){
            // duplicates
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            // 2 pointers
            int left = i+1;
            int right = nums.length - 1;

            while(right>left){
                int value = nums[i] + nums[left] + nums[right];
                if (value == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }
                else if (value > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }

        }
        return result;






//        Set<List<Integer>> set = new HashSet<>();

//        for (int i = 0; i<nums.length; i++){
//            hm.put(nums[i], i);
//        }

//        for (int i = 0; i<nums.length; i++){
//            Map<Integer, Integer> hm = new HashMap<>();
//            for (int j = i+1; j<nums.length; j++){
//                int value = nums[i] + nums[j];
//                if (hm.containsKey(-value)){
//                    List<Integer> li = new ArrayList<>();
//                    li.add(nums[i]);
//                    li.add(nums[j]);
//                    li.add(-value);
//                    // sorted
//                    Collections.sort(li);
////                    if(!result.contains(li)){     // time consuming
////                        result.add(li);
////                    }
//                    set.add(li);
//                }
//                hm.put(nums[j], j);
//            }
//        }
//    return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);



//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> li = new ArrayList<>();
//        li.add(1);
//        li.add(2);
//        li.add(3);
//        result.add(li);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(1);
//        list2.add(2);
//        list2.add(3);
//        System.out.println(result.contains(list2));     //true
    }
}
