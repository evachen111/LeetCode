package Top150;

import java.util.HashMap;

// 169
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            }
//            else{
//                map.put(num, 1);
//            }
            map.put(num, map.getOrDefault(num,0) + 1);
            if (map.get(num) > nums.length/2) {
                return num;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
