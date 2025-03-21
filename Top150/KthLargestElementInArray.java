package Top150;

import java.util.PriorityQueue;

// 215
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums){
            if (pq.size() < k){
                pq.add(num);
            }
            else if (pq.peek()<num){
               pq.poll();
               pq.add(num);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {

    }
}
