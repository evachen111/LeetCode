package Top150;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

// 146
public class LRU {

    Queue<Integer> q = new PriorityQueue<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int size;
    int max;
    public LRU(int capacity) {
        max = capacity;
        size = 0;
    }

    public int get(int key) {
        if (q.size() == 0) return -1;
        if (q.peek() > key) {
            return -1;
        }
        return map.get(q.poll());
    }

    public void put(int key, int value) {
        if (size == max) {
            q.poll();
            size--;
        }
        q.add(key);
        size++;
        map.put(key, value);
    }

    public static void main(String[] args) {

    }
}
