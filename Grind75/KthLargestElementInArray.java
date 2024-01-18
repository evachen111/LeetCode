package Grind75;

import java.util.PriorityQueue;

//215
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>((pair1, pair2) -> pair1 - pair2);
        for (int i : nums){
            if (pq.size()<k){
                pq.add(i);
            }
            else{
                if (i>pq.peek()){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {

    }
}
