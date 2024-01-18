package Grind75;

import java.util.LinkedList;
import java.util.Queue;

// 933
public class RecentCounter {
    public Queue<Integer> q = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        while (!q.isEmpty() && t-q.peek() > 3000){
            q.remove();
        }
        q.add(t);
        return q.size()-1;
    }

    public static void main(String[] args) {

    }
}
