package Grind75;

import java.util.Comparator;
import java.util.PriorityQueue;

// 2336
public class SmallestInfiniteSet {

    public int max;
    public PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });

    public SmallestInfiniteSet() {
        max = 1;
        pq.add(1);
    }

    public int popSmallest() {
        System.out.println(pq.peek());
        System.out.println(max);

        if (pq.peek() == max){
            max++;
            if (!pq.contains(max)){
                pq.add(max);
            }
        }
        return pq.poll();
    }

    public void addBack(int num) {
        if (!pq.contains(num)){
            pq.add(num);
        }
    }
}