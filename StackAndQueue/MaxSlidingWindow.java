package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


//239
public class MaxSlidingWindow {
    private static void monoQue(Deque<Integer> q, int x){
        // sanity check
        if (q.isEmpty()){
            q.addLast(x);
            return;
        }
        int tmp;
        while(!q.isEmpty() && q.getLast() < x){
            tmp = q.removeLast();
        }
        q.addLast(x);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length-k+1];
        Deque<Integer> myQue = new LinkedList<>();     //也可以存idx
        //first window
        int i;
        for (i =0; i<k; i++){
            monoQue(myQue,nums[i]);
        }
        int j = 0;
        result[j++] = myQue.getFirst();

        //sliding
        while (i<nums.length){
            if (nums[i-k] == myQue.getFirst()){
                myQue.removeFirst();
            }
            monoQue(myQue,nums[i++]);
            result[j++] = myQue.getFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int[] re = maxSlidingWindow(nums,1);
        for (int i = 0; i<re.length; i++){
            System.out.println(re[i]);
        }
    }
}
