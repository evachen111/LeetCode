package monoStack;

import java.util.HashMap;
import java.util.Stack;

// 496
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int j = nums2.length-1; j>=0; j--){
            while(!s.isEmpty() && nums2[j] >= s.peek()){
                s.pop();
            }
            if (s.isEmpty()){
                hm.put(nums2[j], -1);
            }
            else{
                hm.put(nums2[j], s.peek());
            }
            s.push(nums2[j]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i<nums1.length; i++){
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
