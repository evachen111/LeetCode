package Grind75;

import java.util.Stack;

//334

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
//        Stack<Integer> st = new Stack<>();
//
//        for (int j = nums.length-1; j>=0; j--){
//            if (st.size()>=3){
//                return true;
//            }
//            while (!st.isEmpty() && st.peek() < nums[j]){
//                st.pop();
//            }
//            st.push(nums[j]);
//        }
//        if (st.size()>=3){
//            return true;
//        }
//        return false;
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for (int i : nums){
            if (i <= a){
                a = i;
            }
            else if (i<=b){
                b= i;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {20,100,10,12,5,13};

        IncreasingTripletSubsequence sol = new IncreasingTripletSubsequence();

        System.out.println(sol.increasingTriplet(nums));
    }
}
